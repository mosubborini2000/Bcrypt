# Bcrypt
I Created a server to protect site content by requiring users to sign up for an account and log in.
then I control that the Users should only be able to see the protected areas of site after they’ve logged in and established an authenticated session.
I created authentication system then Display a user’s username somewhere on the page to indicate to a user that they’re logged in.
in same page user can type his posts and can logut from his account
in sign up i used Bcrypt to hash and check user passwords.
also i used session and deal with it to keep our wep site more secure

Routes
"/" --> Home Page it will show you Two button "Sign In" , "Sign Up"
"/sign-up" --> Sign Up Page to allow to yhe user create new account
"/login" --> Sign In Page to allow to the user login
Note :: The password will be saved as hashed Password in the Database  BCrypt for password hashing 

