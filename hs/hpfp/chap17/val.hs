data Validation err a = Failure err | Success a deriving (Eq, Show)

data Errors = DividedByZero | StackOverflow | MooglesChewedWires deriving (Eq, Show)

