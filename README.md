Requirement:
+ Create test script and Code run without error (50%)
+ Data read from excel file (10%)
+ Design Data Driven Framework (10%)
+ Update test result for-each test case to the Excel file (10%)
+ Must be run with 2 browsers Chrome and Firefox with selenium grid(20%)

TC_CreateNewCategory:
- Action: 
1. Navigate to https://admin-demo.nopcommerce.com/login to login with valid user and pass .
Email: admin@yourstore.com
Pass: admin
2. Click [Catalog -> Categories] menu
3. Click to the add new
4. Click to Category info -> Input
5. Click button Save
6. Logout

- Excepted Result
1. Login success.
- The screen [Admin] displayed (Verify menu left present on Admin page)
2. The screen [Categories] displayed. Verify present on Categories page (Add new, Export, Import, Delete, Category name, Published)
5. Display message: The new category has been added successfully.
6. Logout success.

TC_CreateNewCustomer:
- Action:
1. Navigate to https://admin-demo.nopcommerce.com/login to login with valid user and pass .
Email: admin@yourstore.com
Pass: admin
2. Click [Catalog -> Products] menu .
3. Click to the Add New
4. Input Product Name, Short description, SKU,Categories, Price
5. Click button Save
6. Logout

- Excepted Result:
1. Login success.
- The screen [Admin] displayed (Verify menu left present on Admin page)
2. The screen [Products] displayed. Verify present on Categories page (Add new, Export, Import, Delete, Product name, Warehouse, Category and Product type)
5. Display message: The new product has been added successfully.
6. Logout success.
