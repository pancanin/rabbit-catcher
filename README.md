# Secret seeker 2000

## Strategy
Having a dictionary with all words is great, but we need only those words that have all their letters in the anagram of the phrase.

Spaces in the anagram reveal how many words there should be in the actual secret phrase.

After that we should generate variations from the dictionary and check if the MD5 hash of the phrase matches some of the given MD5 hashes.
