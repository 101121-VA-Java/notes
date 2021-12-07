Space cat pirates Project proposal
Scrum Master: Dean Long
Team:Dean, Albert, Patience, Bezza
 
Space cat will create an application where users can view art items provisioned from the metropolitan art api and place them up for auction for users to bid on. Users will be able to login and update their demographic information and reset their security information. They will also be able to view their bid history. Auctioneers will be able to create auctions using the items provided by the api. They will be able to see bid history by user or by item. They will be able to update their demographic information.

USER STORIES
Auctioneer
Login
Can create auction picks random item in metart one out of 470000. (Metropolitan Museum of Art  API used here)
Can see current items for auction.
Can see bid history on specific user id 
Can see bid on specific item id
Update auctioneer information
Logout
Client
Login
Logout
Homepage
See current bids
Can see bid history - automatic 
Can update user information
View owned art
Can buy using information(mocked)

ER Diagram-
User-table
Id P
First_name varchar(100)
Last_name varchar(100)
Username varchar(100) not null
Password varchar(100) not null
Role_id references roles_id as foreign key

Art table
id P
url varchar(100)
current_highest_bid integer
owner_id  int references user_id as foreign key
highest_bidder_id int references user_id

Role table
Id varchar(100) P
Role varchar(10) not null
