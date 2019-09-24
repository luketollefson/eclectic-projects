data Maybe' a = Nothing' | Just' a

instance Eq a => Eq (Maybe' a) where
   Nothing' == Nothing' = True
   Just' x  == Just' y  = x == y
   _       == _       = False

data List a = Nil | Cons a (List a)

instance Eq a => Eq (List a) where
   Nil       == Nil       = True
   Cons x xs == Cons y ys = x == y && xs == ys
   _         == _         = False

{-
instance Eq a => Eq [a] where
   [] == [] = True
   (x:xs) == (y:ys) = x == y && xs == ys
   _ == _ = False
-}
