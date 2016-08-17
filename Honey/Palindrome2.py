str=raw_input("Enter a string: ");
length=len(str);

'''###JAVA###
for( i=0,j=length;i<length/2;i++,j-- ){
    if(str[i]==str[j]):
       flag=True;
    else:
        flag=false;
        }'''
flag=False;      
j=length-1;     
for i in range(length/2) :
    if(str[i]==str[j]):
        flag=True;
    else:
        flag=False;
    j=j-1;
    
if(flag==True):
    print("Palindrome")
else:
    print("Not a palindrome")
    