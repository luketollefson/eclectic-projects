import Data.Char
import Control.Monad

-- main = do
--   putStrLn "Hello, what's your name?"
--   name <- getLine
--   putStrLn ("Hey " ++ name ++ ", you rock!")

-- main = do
--   putStrLn "What's your first name?"
--   firstName <- getLine
--   putStrLn "What's your last name?"
--   lastName <- getLine
--   let bigFirstName = map toUpper firstName
--       bigLastName = map toUpper lastName
--   putStrLn $ "hey " ++ bigFirstName ++ " "
--                     ++ bigLastName
--                     ++ ", how are you?"

-- main = do
--   line <- getLine
--   if null line
--     then return ()
--     else do
--         putStrLn $ reverseWords line
--         main

-- reverseWords :: String -> String
-- reverseWords = unwords . map reverse . words

-- putStr' :: String -> IO ()
-- putStr' [] = return ()
-- putStr' (x:xs) = do
--   putChar x
--   putStr' xs

-- main = do
--   input <- getLine
--   when (input == "SWORDFISH") $ do
--     putStrLn input

-- main = do
--   input <- getLine
--   if (input == "SWORDFISH")
--     then putStrLn input
--     else return ()
--   putStrLn "JFOWJFIWJ"

main = forever $ do
  putStr "Give me some input: "
  l <- getLine
  putStrLn $ map toUpper l
