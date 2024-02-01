'use district';

let onLoadRequest=()=>{//шаблон для классического http запроса
    $.ajax({
        url:"/onLoadIndex",//специфицировать url
        type:'GET',//тип запроса
        // dataType:'html',
        datatype:'application-json',//тип данных которые мы получаем с бэка
        // data:{
        //     type:'string'
        //     user:{
        //         username:"xxx",
        //         password:'yyy'
        //     }
        // }
        success:(data)=>{// данные которые мы заполняем на бэке             //success блок кода, который выполнится в результате 200 ответа
            console.log(data)
            let response = JSON.parse(data);
            console.log(response)
            completeCategories(response.categories);//заполнить блок категорий сначала заголовки, потом картинки
            //****
            completeBrands(response.brand);
            //****
        }
    })
}
let completeCategories = (categories)=>{
    completeCategoryCaptions(categories);
    completeCategoryImages(categories);
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
    for(let i = 0;i<categories.length;i++){
        img = imageDivs[i].querySelector("img");
        img.src = '/img/categories/'+categories[i]+'.jpg'
    }
}
//****

let completeBrands = (brand)=>{
   // completeCategoryCaptions(categories);
    completeBrandImages(brand);
}


let completeBrandImages=(brand)=>{
    let imageDivs = document.querySelectorAll(".brand_img");
    let img;

    for(let i = 0;i<brand.length;i++){
        img = imageDivs[i].querySelector("img");
        img.src = '/img/brands/'+brand[i]+'.jpg'
    }
}
//****



onLoadRequest();