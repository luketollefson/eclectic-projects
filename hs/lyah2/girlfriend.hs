import System.IO
import Data.Char

-- main = do
--   handle <- openFile "girlfriend.txt" ReadMode
--   contents <- hGetContents handle
--   putStr contents
--   hClose handle

-- main = do
--   withFile "girlfriend.txt" ReadMode (\handle -> do
--       contents <- hGetContents handle
--       putStr contents)

-- main = do
--   contents <- readFile "girlfriend.txt'
--   putStr contents

main = do
  contents <- readFile "girlfriend.txt"
  writeFile "girlfriendcaps.txt" (map toUpper contents)
