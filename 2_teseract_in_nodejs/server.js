const express = require('express');
const tesseract = require("node-tesseract-ocr")

const config = {
    lang:"eng",
    oem:1,
    psm:3
}

//Sample Photo inovice is in same directory. We can give another photo also instead of inovice.jpg

tesseract.recognize("inovice.jpg",config).then(text=>{
    console.log("Result : ",text);
}).catch(error=>{
    console.log("Error\n" + error)
})

const app = express();
