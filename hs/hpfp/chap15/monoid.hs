import Data.Monoid

data Optional a = Nada | Only a deriving (Eq, Show)

instance Monoid a => Monoid (Optional a) where
  mempty = Nada
  mappend (Only a) (Only b) = Only (a <> b)
  mappend a Nada = a
  mappend Nada b = b

data P = Int :!!: String deriving Show

-- data Booly a = False' | True' deriving (Eq, Show)

-- instance Monoid (Booly a) where
--   mappend False' _ = False'
--   mappend _ False' = False'
--   mappend True' True' = True'
