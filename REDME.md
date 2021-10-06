http://localhost:8080/api/v1/sql_query

http://localhost:8080/api/v1/users



SELECT

1. (*, id, name, surname, email, age)
   
       you can use only 1 of them

2. FROM USER
   
       All command is not caseSensitive
       you can read SuRName or SElleCt


SELECT

1. (*, id, name, surname, email, age) 

        you can use only 1 of them

2. FROM USER WHERE

         All is not caseSensitive
         you can read SuRName or SElleCt 

3. id=yourId AND surname=yourSurname AND ... 
   
         In this part I don't read validation
         you must read colum=value without space
         for exsample colume =value. (" =", ".")
         or colume=value, And (",") is incorrect 
         
         correct example
         SELECT * frOM USer where name=Sevak AND age=30

INSERT INTO User
VALUES (value1, value2, value3, ...)

      All command is not caseSensitive
       you can read SuRName or SElleCt
      
      In this part I don't read validation
      you must read (name, surname, email, age)
      for exsample (name, surname,    email , age) (" , ", ",    ")
      or (name, surname, age) ("email ?") is incorrect 
      
      correct example
      INSERT into user 
      values (Sevak, Tovmasyan, seva@mail.ru, 40)

Delete FROM USER Where condition

      All command is not caseSensitive
       you can read SuRName or SElleCt

      In this part I don't read validation
         you must read colum=value without space
         for exsample name =Sevak. (" =", ".")
         or age=20, And (",") is incorrect 

      correct example
         DelETE frOM USer where name=Sevak AND age=30

UPDATE user
SET (name=setName, surname=setSurname, email=setEmail, age=setAge)
WHERE condition

      All command is not caseSensitive
      you can read SuRName or SElleCt

      In this part I don't read validation
         you must read colum=value without space
         you must use ( colum=value, ... ) 
         for exsample name =Sevak. (" =", ".")
         
      correct example
      UPDATE user
      SET (name=Sevak, surname=Tovmasyan)
      WHERE age=30
      