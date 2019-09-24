{-# LANGUAGE FlexibleInstances #-}
newtype Flip f a b = Flip (f b a) deriving (Eq, Show)

newtype K a b = K a

instance Functor (Flip K a) where
  fmap f (Flip (K b)) = Flip $ K (f b)

data EvilGoateeConst a b = GoatyConst b

instance Functor (EvilGoateeConst a) where
  fmap f (GoatyConst b) = GoatyConst (f b)

data LiftItOut f a = LiftItOut (f a)

instance Functor f => Functor (LiftItOut f) where
  fmap f (LiftItOut g) = LiftItOut (fmap f g)

data Parappa f g a = DaWrappa (f a) (g a)

instance (Functor f, Functor g) => Functor (Parappa f g) where
  fmap f (DaWrappa a a') = DaWrappa (fmap f a) (fmap f a')

data IgnoreOne f g a b = IgnoringSomething (f a) (g b)

instance Functor g => Functor (IgnoreOne f g a) where
  fmap f (IgnoringSomething a b) = IgnoringSomething a (fmap f b)

data Notorious g o a t = Notorious (g o) (g a) (g t)

instance Functor g => Functor (Notorious g o a) where
  fmap f (Notorious o a t) = Notorious o a (fmap f t)

data List a = Nil | Cons a (List a)

instance Functor List where
  fmap f (Cons a as) = Cons (f a) (fmap f as)
  fmap f Nil = Nil

data GoatLord a = NoGoat | OneGoat a | MoreGoats (GoatLord a) (GoatLord a) (GoatLord a)

instance Functor GoatLord where
  fmap f (MoreGoats g g' g'') = MoreGoats (fmap f g) (fmap f g') (fmap f g'')
  fmap f (OneGoat a) = OneGoat (f a)
  fmap _ NoGoat = NoGoat

data TalkToMe a = Halt | Print String a | Read (String -> a)

instance Functor TalkToMe where
  fmap f (Read g) = Read (f . g)
  fmap f (Print s a) = Print s (f a)
  fmap _ Halt = Halt
