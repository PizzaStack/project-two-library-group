## Mappings Documentation:
@GetMapping("/Book/title/{title}")****DEPRECATED******use GetMapping("Book/parameter/{parameter}" instead*******
Returns a book by passing it's title. Otherwise it returns string "No matching books found" 
   
@GetMapping("Book/author/{author});****DEPRECATED******use GetMapping("Book/parameter/{parameter}" instead*******
Same response as mapping above this one, except you pass in an author and it searches for that, instead of by title.

@GetMapping("Book/parameter/{parameter}")
Returns json representation of books. You pass in a paramater that is matched against author, title, or keyword. If no books are found by passed parameter, return string "Sorry no books where found with matching criteria". Example of JSON representation of book found: 
 "bookID": 24,
    "title": "Dracula",
    "author": "Bram Stoker",
    "ibsn": 9780486454016,
    "keyword1": {
        "keywordID": 51,
        "value": "fiction"
    },
    "keyword2": {
        "keywordID": 94,
        "value": "darkness"
    },
    "keyword3": {
        "keywordID": 93,
        "value": "vampire"
    },
    "coverimageurl": "https://images-na.ssl-images-amazon.com/images/I/51NtwFIGPfL.jpg",
    "description": "During a business visit to Count Dracula's castle in Transylvania, a young English solicitor finds himself at the center of a series of horrifying incidents. Jonathan Harker is attacked by three phantom women, observes the Count's transformation from human to bat form, and discovers puncture wounds on his own neck that seem to have been made by teeth",
    "patron": {
        "firstName": "John",
        "lastName": "DeJesus",
        "address": "456 MLK Blvd",
        "phoneNumber": 2325557654,
        "emailAddress": "john@mail.com"
    },
    "datecheckedout": "2019-01-31T06:00:00.000+0000"
}

@GetMapping("Book/LoggedInPatron")
Returns json representation of books that are checked out by the logged in Patron. Otherwise it returns string "You don't have any books that are not checked out"

@GetMapping("Book/Patron/{patronUsername}")
Same as previous one above this, except you pass in the patron's username to see what books are checked out by that patron. This assumes you are logged in as a Librarian. 

@GetMapping("Book/Checkout/{title}")
Updates Book to set the date of checked out to current date timestamp, and sets the patronID assocaited with logged in patron to that book, if it is successs, it returns String "Your book was successfully checked out.". If you attempt to checkout a book that does not exist in the library database or one that is currently checked out by another patron, it will return String "Sorry, that book is not available for checkout.".

@GetMapping("Book/Return/{title}")
Updateds book to set it's date of checked out to default value checkedoutvalue, set's patronID associated to patron 0 marking it not being checked out by anyone. If you attempt to type in a book that doesnt exist in the library database. Returns String "This book doesn't exist in the library database". If you attempt to return a book already in the library catalog returns String "This book is already currently in the library catalog". If you successful, prints String "Book was successfully returned".

@GetMapping("Book/GetBooksCheckedOut")
Returns books that are currently checked out by patrons. Description property will not be displayed in the json response. 

@GetMapping("/LoginUser/{username}/{password}")
Logs user in, saves their variables into session in backend. If user does not exist, returns String "User does not exist". If login is successful, returns JSON object representing LoggedInUser ex. {
    "id": 3,
    "username": "@dejesus",
    "password": "john",
    "libraryUserID": 3,
    "librarian": false
}
@GetMapping("/LoginUser/Logout")
Logs user out, kills session data in backend. Returns string "You are logged out";

@GetMapping("/LoginUser/Info")
Returns JSON object representing info of the logged in user. This mapping will only worked if you logged in first. If the user is a librarian, the following example is returned:
{
    "firstName": "Jason",
    "password": "truepassword",
    "usernametname": "@jpresherX",
    "lastname": "Presher"
}
else if logged in user is a patron, the fllowing json is returned.
{
    "firstName": "John",
    "lastName": "DeJesus",
    "password": "john",
    "emailAddress": "john@mail.com",
    "address": "456 MLK Blvd",
    "phoneNumber": 2325557654,
    "username": "@dejesus"
}
@GetMapping("/Patrons")
Returns JSON objects of all patrons in system

@GetMapping("/Patrons/CreateNewPatron/{username}/{password}/{firstName}/{lastName}/{phoneNumber}/{address}/{emailAddress}")
Creates a new Patron in the database. Returns String "Patron has been created" if patron is successfully created. Otherwise returns
String "Failed to create patron account".

@GetMapping("/Patrons/UpdatePatronInfo/{username}/{password}/{firstname}/{lastname}/{phoneNumber}/{address}/{emailAddress}")
Updates patron information based on parameters passed in. If successful returns String "Patron Information has been updated". This mapping assumes you are logged in as a Patron to update your information. 

@GetMapping("/LoginUser/UpdateLibrarianInfo/{username}/{password}/{firstName}/{lastName}")
Updates librarian information based on parameters passed in. If successful returns String "Libarian Information has been updated". This mapping assumes you are logged in as a Librarian to update your information
