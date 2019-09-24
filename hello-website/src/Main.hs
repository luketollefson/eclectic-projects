{-# LANGUAGE OverloadedStrings #-}
module Main where

import Happstack.Server
import           Text.Blaze ((!))
import qualified Text.Blaze.Html4.Strict as H
import qualified Text.Blaze.Html4.Strict.Attributes as A

appTemplate :: String -> [H.Html] -> H.Html -> H.Html
appTemplate title headers body =
    H.html $ do
      H.head $ do
        H.title (H.toHtml title)
        H.meta ! A.httpEquiv "Content-Type" ! A.content "text/html;charset=utf-8"
        sequence_ headers
      H.body $ do
        body

helloBlaze :: ServerPart Response
helloBlaze =
   ok $ toResponse $
    appTemplate "Hello, Blaze!"
                [H.meta ! A.name "keywords" ! A.content "happstack, blaze, html"]
                (H.p "hello, blaze!")

main :: IO ()
main = simpleHTTP nullConf $ helloBlaze

{-
import Control.Monad (msum)
import Happstack.Server (Method(GET, HEAD), dir, method, nullConf, ok, simpleHTTP)

main :: IO ()
main = simpleHTTP nullConf $ msum
       [ do method [GET, HEAD]
            ok $ "Hello, world\n"
       ]
-}

{-
main :: IO ()
main = simpleHTTP nullConf $ msum
       [ dir "foo" $ do method GET
                        ok $ "You did a GET request on /foo\n"
       , do method GET
            ok $ "You did a GET request.\n"
       , do method POST
            ok $ "You did a POST request.\n"
       ]
-}

{-
import Control.Monad (msum)
import Data.Char (toLower)
import Happstack.Server (FromReqURI(..), nullConf, simpleHTTP, ok, dir, path)

data Subject = World | Haskell

sayHello :: Subject -> String
sayHello World   = "Hello, World!"
sayHello Haskell = "Greetings, Haskell!"

instance FromReqURI Subject where
    fromReqURI sub =
        case map toLower sub of
          "haskell" -> Just Haskell
          "world"   -> Just World
          _         -> Nothing

main :: IO ()
main = simpleHTTP nullConf $ dir "hello" $ path $ \subject -> ok $ (sayHello subject)
-}
