import Control.Applicative

data Expr = Val Int
	  | Add Expr Expr
	  | Throw
	  | Catch Expr Expr

{- data Maybe a = Nothing | Just a -}

type Stack = [Maybe Int]

eval :: Expr -> Maybe Int
eval (Val n)     = Just n
eval (Add x y)   = case eval x of
		      Just n -> case eval y of
		         Just m  -> Just (n + m)
		         Nothing -> Nothing
		      Nothing -> Nothing
eval Throw       = Nothing
eval (Catch x h) = case eval x of
		      Just n  -> Just n
		      Nothing -> eval h

{-
PUSH :: Maybe Int -> Code -> Code
NOTHING :: Code
ADD :: Code -> Code
CATCH :: Code -> Code
HALT :: Code
-}

data Code = HALT 
	  | PUSH (Maybe Int) Code
	  | ADD Code
	  | NOTHING Code
	  | CATCH Code

comp' :: Expr -> Code -> Code
comp' (Val n) c = PUSH (Just n) c
comp' (Add x y) c = comp' x (comp' y (ADD c))
comp' Throw c = NOTHING c
comp' (Catch x h) c = comp' x (comp' h (CATCH c))

comp :: Expr -> Code
comp e = comp' e HALT

exec :: Code -> Stack -> Stack
exec HALT s = s
exec (PUSH n c) s = exec c (n : s)
exec (ADD c) (m:n:s) = exec c (((+)<$>n<*>m):s)
exec (NOTHING c) s = exec c (Nothing : s)
exec (CATCH c) (m:n:s) = exec c ((n<|>m):s)

eval' :: Expr -> Maybe Int
eval' e = head (exec (comp e) [])

{- Test Values -}
-- Normal adding
-- Evaluates to Just 28
expr1 :: Expr
expr1 = (Add (Add (Val 1) (Val 9))
            (Add (Val 2) (Add (Val 3) (Val 13))))

-- Throw an exception
-- Evaluates to Just 27
expr2 :: Expr
expr2 = Add (Add (Val 1) (Val 4))
	    (Add 
	        (Catch 
		    (Add Throw (Add Throw Throw))
		    (Val 17)
		)
		(Add (Val 3) (Val 2))
	    )

-- Throws an exception, but isnt caught
-- Evaluates to Nothing
expr3 :: Expr
expr3 = Add (Throw) (Val 3)
