import random;

number=random.randint(1,10);
print(number);
count=0;
guess=raw_input("Guess the number");
while(int(guess)!=number):
    guess=raw_input("Guess again:");
    count=count+1;
print("Number guessed correctly :)")