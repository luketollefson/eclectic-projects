{-# LANGUAGE CPP #-}
{-# LANGUAGE NoRebindableSyntax #-}
{-# OPTIONS_GHC -fno-warn-missing-import-lists #-}
module Paths_hello (
    version,
    getBinDir, getLibDir, getDynLibDir, getDataDir, getLibexecDir,
    getDataFileName, getSysconfDir
  ) where

import qualified Control.Exception as Exception
import Data.Version (Version(..))
import System.Environment (getEnv)
import Prelude

#if defined(VERSION_base)

#if MIN_VERSION_base(4,0,0)
catchIO :: IO a -> (Exception.IOException -> IO a) -> IO a
#else
catchIO :: IO a -> (Exception.Exception -> IO a) -> IO a
#endif

#else
catchIO :: IO a -> (Exception.IOException -> IO a) -> IO a
#endif
catchIO = Exception.catch

version :: Version
version = Version [0,1,0,0] []
bindir, libdir, dynlibdir, datadir, libexecdir, sysconfdir :: FilePath

bindir     = "/home/luke/proj/hello-website/.stack-work/install/x86_64-linux/lts-13.0/8.6.3/bin"
libdir     = "/home/luke/proj/hello-website/.stack-work/install/x86_64-linux/lts-13.0/8.6.3/lib/x86_64-linux-ghc-8.6.3/hello-0.1.0.0-Gvd1h8pBwUr9YNQzlgkNEi-hello"
dynlibdir  = "/home/luke/proj/hello-website/.stack-work/install/x86_64-linux/lts-13.0/8.6.3/lib/x86_64-linux-ghc-8.6.3"
datadir    = "/home/luke/proj/hello-website/.stack-work/install/x86_64-linux/lts-13.0/8.6.3/share/x86_64-linux-ghc-8.6.3/hello-0.1.0.0"
libexecdir = "/home/luke/proj/hello-website/.stack-work/install/x86_64-linux/lts-13.0/8.6.3/libexec/x86_64-linux-ghc-8.6.3/hello-0.1.0.0"
sysconfdir = "/home/luke/proj/hello-website/.stack-work/install/x86_64-linux/lts-13.0/8.6.3/etc"

getBinDir, getLibDir, getDynLibDir, getDataDir, getLibexecDir, getSysconfDir :: IO FilePath
getBinDir = catchIO (getEnv "hello_bindir") (\_ -> return bindir)
getLibDir = catchIO (getEnv "hello_libdir") (\_ -> return libdir)
getDynLibDir = catchIO (getEnv "hello_dynlibdir") (\_ -> return dynlibdir)
getDataDir = catchIO (getEnv "hello_datadir") (\_ -> return datadir)
getLibexecDir = catchIO (getEnv "hello_libexecdir") (\_ -> return libexecdir)
getSysconfDir = catchIO (getEnv "hello_sysconfdir") (\_ -> return sysconfdir)

getDataFileName :: FilePath -> IO FilePath
getDataFileName name = do
  dir <- getDataDir
  return (dir ++ "/" ++ name)
