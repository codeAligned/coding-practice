str=raw_input("Enter a string: ");
length=len(str);
reverse="";
i=length-1;
while i>=0:
    reverse=reverse+str[i];
    i=i-1;
if(str==reverse):
    print("It is a palindrome");
else:
    print("It is not a palindrome")