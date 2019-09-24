{-# LANGUAGE CPP #-}
{-# LANGUAGE NoRebindableSyntax #-}
{-# OPTIONS_GHC -fno-warn-missing-import-lists #-}
module Paths_check (
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

bindir     = "/home/luke/proj/hs/hpfp/chap15/check/.stack-work/install/x86_64-linux/lts-13.27/8.6.5/bin"
libdir     = "/home/luke/proj/hs/hpfp/chap15/check/.stack-work/install/x86_64-linux/lts-13.27/8.6.5/lib/x86_64-linux-ghc-8.6.5/check-0.1.0.0-9LohiUx9KJC6wI2NRJZVkw-check"
dynlibdir  = "/home/luke/proj/hs/hpfp/chap15/check/.stack-work/install/x86_64-linux/lts-13.27/8.6.5/lib/x86_64-linux-ghc-8.6.5"
datadir    = "/home/luke/proj/hs/hpfp/chap15/check/.stack-work/install/x86_64-linux/lts-13.27/8.6.5/share/x86_64-linux-ghc-8.6.5/check-0.1.0.0"
libexecdir = "/home/luke/proj/hs/hpfp/chap15/check/.stack-work/install/x86_64-linux/lts-13.27/8.6.5/libexec/x86_64-linux-ghc-8.6.5/check-0.1.0.0"
sysconfdir = "/home/luke/proj/hs/hpfp/chap15/check/.stack-work/install/x86_64-linux/lts-13.27/8.6.5/etc"

getBinDir, getLibDir, getDynLibDir, getDataDir, getLibexecDir, getSysconfDir :: IO FilePath
getBinDir = catchIO (getEnv "check_bindir") (\_ -> return bindir)
getLibDir = catchIO (getEnv "check_libdir") (\_ -> return libdir)
getDynLibDir = catchIO (getEnv "check_dynlibdir") (\_ -> return dynlibdir)
getDataDir = catchIO (getEnv "check_datadir") (\_ -> return datadir)
getLibexecDir = catchIO (getEnv "check_libexecdir") (\_ -> return libexecdir)
getSysconfDir = catchIO (getEnv "check_sysconfdir") (\_ -> return sysconfdir)

getDataFileName :: FilePath -> IO FilePath
getDataFileName name = do
  dir <- getDataDir
  return (dir ++ "/" ++ name)
