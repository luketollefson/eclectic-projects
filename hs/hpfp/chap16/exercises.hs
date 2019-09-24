e :: IO Integer
e = let ioi = readIO "1" :: IO Integer
        changed = fmap read $ fmap ("123"++) $ fmap show ioi
    in fmap (*3) changed
