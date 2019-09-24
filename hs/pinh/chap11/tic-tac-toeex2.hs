import Data.Char
import Data.List
import System.IO

size :: Int
size = 3

type Grid = [[Player]]

data Player = O | B | X
	      deriving (Eq, Ord, Read)

instance Show Player where
    show O = "O"
    show B = " "
    show X = "X"

next :: Player -> Player
next O = X
next B = B
next X = O

empty :: Grid
empty = replicate size (replicate size B)

full :: Grid -> Bool
full = all (/= B) . concat

turn :: Grid -> Player
turn g = if os <= xs then O else X
         where
	    os = length (filter (== O) ps)
	    xs = length (filter (== X) ps)
	    ps = concat g

wins :: Player -> Grid -> Bool
wins p g = any line (rows ++ cols ++ dias)
	   where
	      line = all (== p)
	      rows = g
	      cols = transpose g
	      dias = [diag g, diag (map reverse g)]

diag :: Grid -> [Player]
diag g = [g !! n !! n | n <- [0..size-1]]

won :: Grid -> Bool
won g = wins O g || wins X g

putGrid :: Grid -> IO ()
putGrid =
  putStrLn . unlines . interleave bar . map showRow
  where bar = concat $ interleave "┼" (replicate size "───")

showRow :: [Player] -> String
showRow []     = ""
showRow [x]    = " " ++ show x
showRow (x:xs) = " " ++ show x ++ " │" ++ showRow xs

{-
putGrid :: Grid -> IO ()
putGrid =
  putStrLn . unlines . concat . interleave bar . map showRow
  where bar = [replicate ((size*4)-1) '-']

showRow :: [Player] -> [String]
showRow = beside . interleave bar . map showPlayer
          where
	     beside = foldr1 (zipWith (++))
	     bar    = replicate 3 "|"

showPlayer :: Player -> [String]
showPlayer O = ["   ", " O ", "   "]
showPlayer B = ["   ", "   ", "   "]
showPlayer X = ["   ", " X ", "   "]
-}

interleave :: a -> [a] -> [a]
interleave x []     = []
interleave x [y]    = [y]
interleave x (y:ys) = y : x : interleave x ys

valid :: Grid -> Int -> Bool
valid g i = 0 <= i && i < size^2 && concat g !! i == B

move :: Grid -> Int -> Player -> [Grid]
move g i p =
   if valid g i then [chop size (xs ++ [p] ++ ys)] else []
   where (xs,B:ys) = splitAt i (concat g) 

chop :: Int -> [a] -> [[a]]
chop n [] = []
chop n xs = take n xs : chop n (drop n xs)

getNat :: String -> IO Int
getNat prompt = do putStr prompt
		   xs <- getLine
		   if xs /= [] && all isDigit xs then
		      return (read xs)
		   else
		      do putStrLn "ERROR: Invalid number"
			 getNat prompt

tictactoe :: IO ()
tictactoe = run empty O

cls :: IO ()
cls = putStr "\ESC[2J"

goto :: (Int,Int) -> IO ()
goto (x,y) = putStr ("\ESC[" ++ show y ++ ";" ++ show x ++ "H")

run :: Grid -> Player -> IO ()
run g p = do cls
             goto (1,1)
	     putGrid g
	     run' g p

run' :: Grid -> Player -> IO ()
run' g p | wins O g  = putStrLn "Player O wins!\n"
         | wins X g  = putStrLn "Player X wins!\n"
	 | full g    = putStrLn "It's a draw!\n"
	 | otherwise =
	      do i <- getNat (prompt p)
		 case move g i p of
		    [] -> do putStrLn "ERROR: Invalid move"
			     run' g p
		    [g'] -> run g' (next p)

prompt :: Player -> String
prompt p = "Player " ++ show p ++ ", enter your move: "

data Tree a = Node a [Tree a]
	      deriving Show

gametree :: Grid -> Player -> Tree Grid
gametree g p = Node g [gametree g' (next p) | g' <- moves g p]

moves :: Grid -> Player -> [Grid]
moves g p
   | won g     = []
   | full g    = []
   | otherwise = concat [move g i p | i <- [0..((size^2)-1)]]

prune :: Int -> Tree a -> Tree a
prune 0 (Node x _)  = Node x []
prune n (Node x ts) = Node x [prune (n-1) t | t <- ts]

depth :: Int
depth = 9

minimax :: Tree Grid -> Tree (Grid,Player)
minimax (Node g [])
   | wins O g  = Node (g,O) []
   | wins X g  = Node (g,X) []
   | otherwise = Node (g,B) []
minimax (Node g ts)
   | turn g == O = Node (g, minimum ps) ts'
   | turn g == X = Node (g, maximum ps) ts'
		   where
		      ts' = map minimax ts
		      ps  = [p | Node (_,p) _ <- ts']

initialtree :: Tree (Grid,Player)
initialtree = minimax (gametree empty O)

bestmove :: Tree (Grid,Player) -> Player -> Tree (Grid,Player)
bestmove (Node (g,best) ts) _ = head [(Node (g',p') ts') | (Node (g',p') ts') <- ts, p' == best]

{-
bestmove :: Grid -> Player -> Grid
bestmove g p = head [g' | Node (g',p') _ <- ts, p' == best]
	       where
		  tree = prune depth (gametree g p)
		  Node (_,best) ts = minimax tree
-}

{- Chooses the shortest branch
minimax :: Tree Grid -> Tree (Grid,Player,Int)
minimax (Node g [])
   | wins O g  = Node (g,O,0) []
   | wins X g  = Node (g,X,0) []
   | otherwise = Node (g,B,0) []
minimax (Node g ts)
   | turn g == O = Node (g, min, mind+1) ts'
   | turn g == X = Node (g, max, maxd+1) ts'
		   where
		      ts' = map minimax ts
		      ps  = [(p,d) | Node (_,p,d) _ <- ts']
		      min = minimum . map fst $ ps
		      max = maximum . map fst $ ps
		      (_,mind) = minimum . filter ((==min) . fst) $ ps
		      (_,maxd) = minimum . filter ((==max) . fst) $ ps

bestmove :: Grid -> Player -> Grid
bestmove g p = snd . minimum $ moves
	       where
		  tree = prune depth (gametree g p)
		  Node (_,best,_) ts = minimax tree
		  moves = [(d',g') | Node (g',p',d') _ <- ts, p' == best]
-}

main :: IO ()
main = do hSetBuffering stdout NoBuffering
	  putStrLn "Select O to go first and X to go second"
	  hp <- getLine
          play initialtree O (read hp :: Player)

play :: Tree (Grid,Player) -> Player -> Player -> IO ()
play t p hp = do cls
		 goto (1,1)
		 putGrid ((\(Node (g,_) _) -> g) t)
		 play' t p hp

play' :: Tree (Grid,Player) -> Player -> Player -> IO ()
play' (Node (g,p') ts) p hp
   | wins O g = putStrLn "Player O wins!\n"
   | wins X g = putStrLn "Player X wins!\n"
   | full g   = putStrLn "It's a draw!\n"
   | p == hp   = do i <- getNat (prompt hp)
		    case move g i p of
		       [] -> do putStrLn "Error: Invalid move"
				play' (Node (g,p') ts) p hp
		       [g'] -> play (head [Node (gr,pl) tis | Node (gr,pl) tis <- ts]) (next p) hp
   | p == next hp = do putStr "Player "
		       putStr (show . next $ hp)
		       putStr " is thinking... "
		       (play $! (bestmove (Node (g,p') ts) p)) (next p) hp

{-
play :: Grid -> Player -> Player -> IO ()
play g p hp = do cls
	         goto (1,1)
	         putGrid g
	         play' g p hp

play' :: Grid -> Player -> Player -> IO ()
play' g p hp
   | wins O g     = putStrLn "Player O wins!\n"
   | wins X g     = putStrLn "Player X wins!\n"
   | full g       = putStrLn "It's a draw!\n"
   | p == hp      = do i <- getNat (prompt hp)
		       case move g i p of
		          [] -> do putStrLn "ERROR: Invalid move"
		     	           play' g p hp
		          [g'] -> play g' (next p) hp
   | p == next hp = do putStr "Player "
		       putStr (show . next $ hp)
		       putStr " is thinking... "
		       (play $! (bestmove g p)) (next p) hp
-}

treesize :: Tree a -> Int
treesize (Node x []) = 1
treesize (Node x ts) = 1 + sum [treesize t | t <- ts]

{- size of empty game tree
main :: IO ()
main = do putStrLn (show  (treesize (gametree empty O)))
-} 
