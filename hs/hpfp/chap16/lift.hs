liftedInc :: (Functor f, Num b) => f b -> f b
liftedInc = fmap (+1)

liftedShow :: (Functor f, Show a) => f a -> f String
liftedShow = fmap show

data Possibly a = LolNope | Yeppers a deriving (Eq, Show)

instance Functor Possibly where
  fmap f (Yeppers a) = Yeppers (f a)
  fmap f LolNope = LolNope

data Sum a b = First a | Second b deriving (Eq, Show)

instance Functor (Sum a) where
  fmap f (Second b) = Second (f b)
  fmap _ (First b)  = First b

data Wrap f a = Wrap (f a) deriving (Eq, Show)

instance Functor f => Functor (Wrap f) where
  fmap f (Wrap fa) = Wrap (fmap f fa)

getInt :: IO Int
getInt = fmap read getLine

meTooIsm :: IO String
meTooIsm = fmap (++ " and me too!") getLine
-- meTooIsm = do
--   input <- getLine
--   return (input ++ "and me too!")

bumpIt :: IO Int
bumpIt = fmap (+1) getInt
-- bumpIt = do
--   intVal <- getInt
--   return (intVal + 1)
