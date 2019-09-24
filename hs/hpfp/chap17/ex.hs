import System.IO

-- pure' :: a -> [a]
-- pure' x = [x]

-- app :: [(a -> b)] -> [a] -> [b]
-- app fs xs = [f x | f <- fs, x <- xs]

-- pureIO :: a -> IO a
-- pureIO x = do
--   return x

-- appIO :: IO (a -> b) -> IO a -> IO b
-- appIO fio aio = do
--   f <- fio
--   a <- aio
--   return $ f a

pureT :: a -> (b -> (a, b))
pureT a = (,) a

appT :: (c -> ((a -> b), c)) -> (c -> (a, c)) -> (c -> (b, c))
appT f a = \c -> ((fst $ f c) (fst $ a c), c)


