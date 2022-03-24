
$("#insertar-oculto").hide();

function ShowHideInsertar(){
    let text ="";
    if($("#btn-insertar").text() === "Insertar"){
        $("#insertar-oculto").show();
        text= "Hide Insertar"
    }else{
        $("#insertar-oculto").hide();
        text ="Insertar";
    }

    $("#btn-insertar").html(text);
}


$("#buscar-oculto").hide();
function ShowHideBuscar(){
    let text = "";
    if($("#btn-buscar").text() === "Buscar"){
        $("#buscar-oculto").show();
        text= "Hide buscar"
    }else{
        $("#buscar-oculto").hide();
        text ="Buscar";
    }

    $("#btn-buscar").html(text);
}


//METODO PARA OCULTAR CONTENIDO MODIFICAR
$("#modificar-oculto").hide();
function ShowHideModificar(){
    let text = "";
    if($("#btn-modificar").text() === "Modificar"){
        $("#modificar-oculto").show();
        text= "Hide Modificar"
    }else{
        $("#modificar-oculto").hide();
        text ="Modificar";
    }

    $("#btn-modificar").html(text);
}
 




//METODO PARA OCULTAR CONTENIDO BORRAR
$("#borrar-oculto").hide();
function ShowHideBorrar(){
    let text = "";
    if($("#btn-borrar").text() === "Borrar"){
        $("#borrar-oculto").show();
        text= "Hide Borrar"
    }else{
        $("#borrar-oculto").hide();
        text ="Borrar";
    }

    $("#btn-borrar").html(text);
}




//METODO PARA OCULTAR CONTENIDO ATRACCIONES
$("#atraccion-oculto").hide();
function ShowHideAtracciones(){
    let text = "";
    if($("#btn-atraccion").text() === "Atracciones"){
        $("#atraccion-oculto").show();
        text= "Hide Atracciones";
    }else{
        $("#atraccion-oculto").hide();
        text ="Atracciones";
    }

    $("#btn-atraccion").html(text);
}
 

//METODO PARA OCULTAR CONTENIDO PROMOCION
$("#promocion-oculto").hide();
function ShowHidePromociones(){
    let text = "";
    if($("#btn-promocion").text() === "Promociones"){
        $("#promocion-oculto").show();
        text= "Hide Promociones"
    }else{
        $("#promocion-oculto").hide();
        text ="Promociones";
    }

    $("#btn-promocion").html(text);
}
 
//METODO PARA OCULTAR CONTENIDO ITINERARIO
$("#itinerario-oculto").hide();
function ShowHideItinerario(){
    let text = "";
    if($("#btn-itinerario").text() === "Itinerario"){
        $("#itinerario-oculto").show();
        text= "Hide Itinerario"
    }else{
        $("#itinerario-oculto").hide();
        text ="Itinerario";
    }

    $("#btn-itinerario").html(text);
}



//METODO PARA OCULTAR CONTENIDO HISTORIAL
$("#historial-oculto").hide();
function ShowHideHistorial(){
    let text = "";
    if($("#btn-historial").text() === "Historial"){
        $("#historial-oculto").show();
        text= "Hide Historial"
    }else{
        $("#historial-oculto").hide();
        text ="Historial";
    }

    $("#btn-historial").html(text);
}
