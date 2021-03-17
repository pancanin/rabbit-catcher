# Secret seeker 2000

## Strategy
Having a dictionary with all words is great, but we need only those words that have all their letters in the anagram of the phrase.

Spaces in the anagram reveal how many words there should be in the actual secret phrase.

After that we should generate variations from the dictionary and check if the MD5 hash of the phrase matches some of the given MD5 hashes.

We can generate variations of different permutations of the words that make sense and run the algorithm in parallel. I have 4 cores so I will just choose 4 different arrangements.

In theory, the more cores we have, we can find the anagram faster.

We would have:
1. normal arrangement 
2. shuffled normal arrangement
3. reverse
4. shuffled reverse

From 5 to N cores just shuffle the normal arrangement.

With that optimisation I managed to generate the anagram phrase for medium hash in < 3 minutes.

Easy - printout stout yawls
Medium - ty outlaws printouts
Hard - generated it once but I wont try again because my laptop is fried
