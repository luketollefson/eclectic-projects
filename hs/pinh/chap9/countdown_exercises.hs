import Data.List

data Op = Add | Sub | Mul | Div | Exp
          deriving (Eq, Ord)

instance Show Op where
   show Add = "+"
   show Sub = "-"
   show Mul = "*"
   show Div = "/"
   show Exp = "^"

valid :: Op -> Int -> Int -> Bool
valid Add x y = x <= y
valid Sub x y = x > y
valid Mul x y = x /= 1 && y /= 1 && x <= y
valid Div x y = y /= 0 && y /= 1 && x `mod` y == 0
valid Exp x y = x > 1 && y >= 2

apply :: Op -> Int -> Int -> Int
apply Add x y = x + y
apply Sub x y = x - y
apply Mul x y = x * y
apply Div x y = x `div` y
apply Exp x y = x ^ y

data Expr = Val Int | App Op Expr Expr
            deriving (Eq, Ord)
   

instance Show Expr where
   show (Val n)     = show n
   show (App o l r) = brak l ++ show o ++ brak r
		      where
			 brak (Val n) = show n
			 brak e       = "(" ++ show e ++ ")"

-- evalaute the values of an expression
values :: Expr -> [Int]
values (Val n) = [n]
values (App _ l r) = values l ++ values r

-- evaluate an expression
eval :: Expr -> [Int]
eval (Val n) = [n | n > 0]
eval (App o l r) = [apply o x y | x <- eval l,
			          y <- eval r,
				  valid o x y]

-- evaluate all possible subsequences
subs :: [a] -> [[a]]
subs [] = [[]]
subs (x:xs) = yss ++ map (x:) yss
	      where yss = subs xs

-- evaluate all possible ways of inserting a new element
interleave :: a -> [a] -> [[a]]
interleave x []     = [[x]]
interleave x (y:ys) = (x:y:ys) : map (y:) (interleave x ys)

-- evaluate all permutations
perms :: [a] -> [[a]]
perms []     = [[]]
perms (x:xs) = concat (map (interleave x) (perms xs))

-- evalaute all permutations of subsequences
choices :: [a] -> [[a]]
choices = concat . map perms . subs

-- evaluate all permutations of subsequences
choices' :: [a] -> [[a]]
choices' xs = [zs | ys <- subs xs, zs <- perms ys]

-- evaluate if one list is chosen from another
isChoice :: Eq a => [a] -> [a] -> Bool
isChoice []     []     = True
isChoice []     _      = True
isChoice _      []     = False
isChoice (x:xs) (y:ys) = if x == y then isChoice xs ys 
			    else isChoice (x:xs) ys

-- evaluate if something is a solution to the countdown problem
solution :: Expr -> [Int] -> Int -> Bool
solution e ns n =
   elem (values e) (choices ns) && eval e == [n]

e :: Expr
e = App Mul (App Add (Val 1) (Val 50)) (App Sub (Val 25) (Val 10))

-- evaluate all the possible ways to split a list into two
split :: [a] -> [([a],[a])]
split [] = []
split [_] = []
split (x:xs) = ([x],xs) : [(x:ls,rs) | (ls,rs) <- split xs]

-- evaluate all possible expressions whose list of values is
-- percisely a given list
exprs :: [Int] -> [Expr]
exprs []  = []
exprs [n] = [Val n]
exprs ns  = [e | (ls,rs) <- split ns,
	    	 l       <- exprs ls,
		 r       <- exprs rs,
		 e       <- combine l r]

ops :: [Op]
ops = [Add,Sub,Mul,Div,Exp]

-- evaluate all operations on two expressions
combine :: Expr -> Expr -> [Expr]
combine l r = [App o l r | o <- ops]

-- evaluate all solutions to the countdown problem
solutions :: [Int] -> Int -> [Expr]
solutions ns n =
   [e | ns' <- choices ns, e <- exprs ns', eval e == [n]]

type Result = (Expr,Int)

results :: [Int] -> [Result]
results [n] = [(Val n,n) | n > 0]
results ns = [res | (ls,rs) <- split ns,
		    lx      <- results ls,
		    ry      <- results rs,
		    res     <- combine' lx ry]

combine' :: Result -> Result -> [Result]
combine' (l,x) (r,y) =
   [(App o l r, apply o x y) | o <- ops, valid o x y]

solutions' :: [Int] -> Int -> [Expr]
solutions' ns n =
  [e | ns' <- choices ns, (e,m) <- results ns', m == n]


solutions'' :: [Int] -> Int -> [Expr]
solutions'' ns n =
  if length exact > 0 then reverse (sort exact) else reverse (sort near)
     where exact = [e | e <- near, eval e == [n]]
	   near = [e | ns' <- choices ns, (e,m) <- results ns', abs(m-n) <= 2]

main :: IO ()
main = print (solutions'' [1,3,7,10,25,50] 735)
