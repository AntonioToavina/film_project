const fileInput=document.getElementById("pic")
const img=document.getElementById("img")
let imagesArray=[]

function displayImages(){
    imagesArray.forEach((image,index)=>{ç
        img.src=URL.createObjectURL(image)
    })
}

fileInput.addEventListener('change',function(){
    const file=fileInput.files
    imagesArray.push(file[0])
    displayImages()
})