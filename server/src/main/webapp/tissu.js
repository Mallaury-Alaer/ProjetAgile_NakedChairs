/**
 * 
 */
function afficher(url){
     $.getJSON(url, function(data) {
     	    afficheTissu(data);
        });
}

function afficheTissu(data){
	var retour;
	for (index = 0; index < data.length; ++index) {
		retour += "<li>" +data[index].nom + " : <b> longueur : "+data[index].longueur+ " : <b> largeur : "+data[index].largeur +" Type: "+data[index].type+" luminosite :"+data[index].luminosite+"</li>";
	}
	$("#tissu").html(retour);

}

function add(nom,long,larg,url){
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : url,
		dataType : "json",
		data : JSON.stringify({
			"nom" : nom,
			"longueur" : long,
			"largeur" : larg,
		}),
		success : function(data, textStatus, jqXHR) {
			console.log(data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log('postUser error: ' + textStatus);
		}
	});
	
}