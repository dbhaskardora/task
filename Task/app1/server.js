const express= require("express");
const jwt = require("jsonwebtoken");
const mysql= require("mysql");
const cors= require('cors');
const app=express();
const secretKey="secretkey";
app.use(cors());
app.use(express.json());

const db= mysql.createConnection({
    host:"localhost",
    user:"root",
    password:"",
    database:"signup"
});

app.post('/signup',(req,res) =>{
    const sql="INSERT INTO login(`name`,`email`,`password`) VALUES (?)";
    const values=[
        req.body.name,
        req.body.email,
        req.body.password
    ]
    db.query(sql,[values],(err,data)=>{
        if(err){
            return res.json("Error");
        }
        return res.json(data);
    })
})

app.post('/login',(req,res) =>{
    const sql="SELECT * FROM login WHERE `email`=? AND `password`=?";
    db.query(sql,[req.body.email, req.body.password],(err,data)=>{
        if(err){
            return res.json("Error");
        }
        if(data.length>0){  
            return res.json("success");

        }
         else{
         return res.json("Failed");  
        //    return jwt.sign({sql},secretKey,{expiresIn:'200s'},(err,token)=>{
        //     res.json({
        //         token
        //     })
        // })
    }
    })
})
app.post("/jwt", (req,res)=>{
    const user={
        id: 1,
        username:"bhaskar",
        email:"bhaskar@gmail.com"
    }
        jwt.sign({user},secretKey,{expiresIn:'200s'},(err,token)=>{
        res.json({
            token
        })
    })
  })
app.listen(8081,()=>{
    console.log("listening");
})