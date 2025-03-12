import pyperclip as p

#loop safety
e = 1



seperator = ";"
while (True and e<1000):
    p.waitForNewPaste()

    word = p.paste()

    if word=="end":
        break

    print(word)
    word = word.split("\n")

    while "" in word:
        word.remove("")

    word = seperator.join(word)
    print(word)
    p.copy(word)

    for x in word:
        print("b:"+x+"="+x.encode("unicode_escape").hex())
    

    e+=1
