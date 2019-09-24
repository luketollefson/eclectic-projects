import Control.Monad
import System.Exit (exitSuccess)

main :: IO ()
main = forever $ do
  line1 <- getLine
  case (line1 == reverse line1) of
    True -> putStrLn "It's a palindrome!"
    False -> do putStrLn "Nope!"
                exitSuccess

