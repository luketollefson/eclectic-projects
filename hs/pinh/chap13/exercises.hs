import Control.Applicative
import Data.Char
import System.IO

newtype Parser a = P (String -> [(a,String)])

parse :: Parser a -> String -> [(a,String)]
parse (P p) inp = p inp

item :: Parser Char
item = P (\inp -> case inp of
		     []     -> []
		     (x:xs) -> [(x,xs)])

instance Functor Parser where
   -- fmap :: (a -> b) -> Parser a -> Parser b
   fmap g p = P (\inp -> case parse p inp of
			    []        -> []
			    [(v,out)] -> [(g v, out)])

instance Applicative Parser where
   -- pure :: a -> Parser a
   pure v = P (\inp -> [(v,inp)])

   -- <*> :: Parser (a -> b) -> Parser a -> Parser b
   pg <*> px = P (\inp -> case parse pg inp of
		     [] -> []
		     [(g,out)] -> parse (fmap g px) out)

instance Monad Parser where
   -- (>>=) :: Parser a -> (a -> Parser b) -> Parser b
   p >>= f = P (\inp -> case parse p inp of
			   []        -> []
			   [(v,out)] -> parse (f v) out)

instance Alternative Parser where
   -- empty :: Parser a
   empty = P (\inp -> [])

   -- (<|>) :: Parser a -> Parser a -> Parser a
   p <|> q = P (\inp -> case parse p inp of
			   []        -> parse q inp
			   [(v,out)] -> [(v,out)])

sat :: (Char -> Bool) -> Parser Char
sat p = do x <- item
	   if p x then return x else empty

digit :: Parser Char
digit = sat isDigit

lower :: Parser Char
lower = sat isLower

upper :: Parser Char
upper = sat isUpper

letter :: Parser Char
letter = sat isAlpha

alphanum :: Parser Char
alphanum = sat isAlphaNum

char :: Char -> Parser Char
char x = sat (== x)

string :: String -> Parser String
string []     = return []
string (x:xs) = do char x
		   string xs
		   return (x:xs)

ident :: Parser String
ident = do x  <- lower
	   xs <- many alphanum
	   return (x:xs)

nat :: Parser Int
nat = do xs <- some digit
	 return (read xs)

space :: Parser ()
space = do many (sat isSpace)
	   return ()

int :: Parser Int
int = do char '-'
	 n <- nat
	 return (-n)
      <|> nat

token :: Parser a -> Parser a
token p = do space
	     v <- p
	     space
	     return v

identifier :: Parser String
identifier = token ident

natural :: Parser Int
natural = token nat

integer :: Parser Int
integer = token int

symbol :: String -> Parser String
symbol xs = token (string xs)

nats :: Parser [Int]
nats = do symbol "["
	  n  <- natural
	  ns <- many (do symbol ","
			 natural)
	  symbol "]"
	  return (n:ns)

comment :: Parser ()
comment = do symbol "--"
	     many (sat (/= '\n'))
	     return ()

-- parsing the string into a Expr tree
{-
data Expr = Nat Int | Add Expr Expr | Mul Expr Expr
            deriving Show

expr :: Parser Expr
expr = do t <- term
	  do symbol "+"
	     e <- expr
	     return (Add t e)
	   <|> return t

term :: Parser Expr
term = do f <- factor
	  do symbol "*"
	     t <- term
	     return (Mul f t)
	   <|> return f

factor :: Parser Expr
factor = do symbol "("
	    e <- expr
	    symbol ")"
	    return e
	  <|> fmap (Nat) natural

eval :: String -> Expr
eval xs = case (parse expr xs) of
	     [(es,[])] -> es
	     [(_,out)] -> error ("Unused input " ++ out)
	     []	       -> error "Invalid input"
-}

-- Add support for subtraction, division, exponents, and ints
{-
expr :: Parser Int
expr = do t <- term
	  do symbol "+"
	     e <- expr
	     return (t + e)
	   <|> do symbol "-"
	          e <- expr
	          return (t - e)
	        <|> return t

term :: Parser Int
term = do f <- factor
	  do symbol "*"
	     t <- term
	     return (f * t)
	   <|> do symbol "/"
		  t <- term
		  return (f `div` t)
		<|> return f

factor :: Parser Int
factor = do e <- pow
	    do symbol "^"
	       f <- factor
	       return (e ^ f)
	     <|> return e

pow :: Parser Int
pow = do symbol "("
         e <- expr
	 symbol ")"
	 return e
       <|> integer
-}

-- Subtract (left assosiate)
{- Original
expr ::= term (+ expr | - expr | "")
term ::= factor (* term | / term | "")
factor ::= ( expr ) | int
int ::= ...|-1|0|1|...
-}
{- Exercise 8
expr :: Parser Int
expr = do t <- term
	  do symbol "+"
	     e <- expr
	     return (t + e)
	   <|> do ts <- many (do symbol "-"
				 term)
		  return (foldl (-) t ts)
		<|> return t

term :: Parser Int
term = do f <- factor
	  do symbol "*"
	     t <- term
	     return (f * t)
	   <|> return f

factor :: Parser Int
factor = do symbol "("
	    e <- expr
	    symbol ")"
	    return e
	  <|> natural
-}

-- Original
expr :: Parser Int
expr = do t <- term
	  do symbol "+"
	     e <- expr
	     return (t + e)
	   <|> return t

term :: Parser Int
term = do f <- factor
	  do symbol "*"
	     t <- term
	     return (f * t)
	   <|> return f

factor :: Parser Int
factor = do symbol "("
	    e <- expr
	    symbol ")"
	    return e
	  <|> natural

{-
eval :: String -> Int
eval xs = case (parse expr xs) of
	     [(n,[])]  -> n
	     [(_,out)] -> error ("Unused input " ++ out)
	     []	       -> error "Invalid input"
-}

{- Screen Utilities -}
cls :: IO ()
cls = putStr "\ESC[2J"

type Pos = (Int,Int)

writeat :: Pos -> String -> IO ()
writeat p xs = do goto p
		  putStr xs

goto :: Pos -> IO ()
goto (x,y) = putStr ("\ESC[" ++ show y ++ ";" ++ show x ++ "H")

getCh :: IO Char
getCh = do hSetEcho stdin False
	   x <- getChar
	   hSetEcho stdin True
	   return x
{- End of Screen Utilities -}

box :: [String]
box = ["+---------------+",
       "|               |",
       "+---+---+---+---+",
       "| q | c | d | = |",
       "+---+---+---+---+",
       "| 1 | 2 | 3 | + |",
       "+---+---+---+---+",
       "| 4 | 5 | 6 | - |",
       "+---+---+---+---+",
       "| 7 | 8 | 9 | * |",
       "+---+---+---+---+",
       "| 0 | ( | ) | / |",
       "+---+---+---+---+"]

buttons :: String
buttons = standard ++ extra
	  where
	     standard = "qcd=123+456-789*0()/"
	     extra    = "qcd \ESC\BS\DEL\n"

showbox :: IO ()
showbox = sequence_ [writeat (1,y) b | (y,b) <- zip [1..] box]

display xs = do writeat (3,2) (replicate 13 ' ')
		writeat (3,2) (reverse (take 13 (reverse xs)))
			
beep :: IO ()
beep = putStr "\BEL"

calc :: String -> IO ()
calc xs = do display xs
	     c <- getCh
	     showbox
	     if elem c buttons then
		 process c xs
	     else
		 do beep
		    calc xs

process :: Char -> String -> IO ()
process c xs | elem c "qQ\ESC"    = quit
	     | elem c "dD\BS\DEL" = delete xs
	     | elem c "=\n"       = eval xs
	     | elem c "cC"        = clear
	     | otherwise          = press c xs

quit :: IO ()
quit = goto (1,14)

delete :: String -> IO ()
delete [] = calc []
delete xs = calc (init xs)

eval :: String -> IO ()
eval xs = case parse expr xs of
	     [(n,[])] -> calc (show n)
	     [(n,ys)] -> do writeat (max 3 ((min 13 (length xs) - length ys) + 3), 3) "^" 
		  	    beep
			    calc xs

clear :: IO ()
clear = calc []

press :: Char -> String -> IO ()
press c xs = calc (xs ++ [c])

run :: IO ()
run = do cls
	 showbox
	 clear
