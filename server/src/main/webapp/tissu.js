/**
 * 
 */
function afficher(url){
     $.getJSON(url, function(data) {
     	    afficheTissu(data);
        });
}

function afficheTissu(data){
	var retour="";
	for (index = 0; index < data.length; ++index) {
		retour += "<li>" +data[index].nom + " : <b> longueur : "+data[index].longueur+ " : <b> largeur : "+data[index].largeur +" Type: "+data[index].type+" luminosite :"+data[index].luminosite+"</li>";
	}
	$("#tissu").html(retour);

}

function add(nom,long,larg,type,luminosite,url){
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : url,
		dataType : "json",
		data : JSON.stringify({
			"nom" : nom,
			"longueur" : long,
			"largeur" : larg,
			"type" : type,
			"luminosite" : luminosite,
		}),
		success : function(data, textStatus, jqXHR) {
			console.log(data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log('postUser error: ' + textStatus);
		}
	});
}

function del(nom,url){
	$.ajax({
		type : 'DELETE',
		contentType : 'application/json',
		url : url +"/" +nom,
		dataType : "json",
		data : JSON.stringify({
			"nom" : nom,
		}),
		success : function(data, textStatus, jqXHR) {
			console.log(data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log('postUser error: ' + textStatus);
		}
	});
}