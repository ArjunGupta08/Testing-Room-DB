# Unit Testing - Room Database
 - Unit test room database along with LiveData testing.
 - Unit testing room involves testing DAO.
 - Queries inside DAO are unit tested
 - for this we have a InMemoryDatabaseBuilder from Room Library that helps to write the test cases for Room Database Component.
 - This **inMemory DB** get closed on closing the application

We have setup a new Room DB along with Entities and DAO. Different test cases were executed to test CRUD(Insert/Update/Delete/Read) operations. Learn how to write unit test cases for Room DB. 
Learn how to test LiveData objects using a special extension method that depends on CountDownLatch class in Kotlin.

