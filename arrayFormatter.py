import pyperclip as p

#loop safety
e = 1



seperator = ";"
while (True and e<1000):
    

    p.waitForNewPaste()

    word = p.paste()

    if word=="end":
        break
    e+=1
    
    
        
    print(word)
    # for x in word:
    #     print("b:"+x+"="+str(x.encode("unicode_escape")))

    word = word.split("\n")

    while "" in word:
        word.remove("")

    

    word = seperator.join(word)

    while "\r" in word:
        word = word[:word.index('\r')]+word[word.index('\r')+1:]
    
    
    

    
    print(word)

    
    p.copy(word)
    


    for x in word:
        print("b:"+x+"="+str(x.encode("unicode_escape")))
    

    
