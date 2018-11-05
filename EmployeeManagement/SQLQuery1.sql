Create database EmployeeDB
go
use EmployeeDB
go
create table Employee(
	Id int primary key entity,
	Name nvarchar(100) not null,
	Age int not null,
	[Address] nvarchar(100)
)
go
select * from Employee
go
insert into Employee values ('Rick', 43, 'USA')
insert into Employee values ('Sean', 30, 'USA')
insert into Employee values ('Dean', 26, 'USA')
go
create proc getAllEmployee
as
	select * from Employee
go
exec getAllEmployee
go
create proc insertEmployee
	@name nvarchar(100),
	@age int,
	@address nvarchar(100)
as
	insert into Employee values (@name, @age, @address)
go
exec insertEmployee 'Bill', 40, 'Berlin'
go
create proc removeEmployee
	@id int
as
	delete Employee where Id=@id
go
exec removeEmployee 1
go