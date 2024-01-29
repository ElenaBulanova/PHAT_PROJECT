'use district';

let onLoadRequest=()=>{
    $.ajax({
        url:"/onLoadIndex",
        type:'GET',
        dataType:'html',
        datatype:'application-json',
        // data:{
        //     type:'string'
        //     user:{
        //         username:"xxx",
        //         password:'yyy'
        //     }
        // }
        success:function(data){
            let response = JSON.parse(data);
            console.log(response)
            completeCategories(response.categories);
        }
    })
}
let completeCategories = (category)=>{
    completeCategoryCaptions(response);
    completeCategoryImages(response);
}

let completeCategoryCaptions = (categories)=>{
    let captions = document.querySelectorAll(".group_caption");
    for(let i = 0;i<captions.length;i++){
        captions[i].innerHTML = '<p>'+categories[i]+'</p>'
    }
}

let completeCategoryImages=(categories)=>{
    let imageDivs = document.querySelectorAll(".group_img");
    let img;
    for(let i = 0;captions.length;i++){
        img = imageDivs[i].querySelector("img");
        img.src = '/img/categories/'+categories[i]+'.jpg'
    }
}