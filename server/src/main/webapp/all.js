function getUserBdd(email) {
	getUserGeneric(email, "v1/user/");
}

function getUserGeneric(email, url) {
	$.getJSON(url + email, function(data) {
		afficheUser(data);
	});
}

function getForAll() {
	// envoie vers accueil
	getSecure("v1/secure/who");
}

function getByAnnotation() {
	getSecure("v1/secure/byannotation");
}

function getSecure(url) {
	if($("#userlogin").val() != "") {
		$.ajax
		({
			type: "GET",
			url: url,
			dataType: 'json',
			beforeSend : function(req) {
				req.setRequestHeader("Authorization", "Basic " + btoa($("#userlogin").val() + ":" + $("#passwdlogin").val()));
			},
			success: function (data,jqXHR, textStatus, errorThrown) {
				$('.connexion').hide();
				$('.deconnexion').show();
				if(data.role=="admin"){
					document.location.href="admin.html"; 
				}
				else{
					// Probleme, on n'arrive pas a cacher connexion et montrer deconnexion apres connection réussi
					
					document.location.href="index.html";
					}
				
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert('error: ' + textStatus);
			}
		});
	} else {
		$.getJSON(url, function(data) {
			afficheUser(data);
		});
	}
}

function annuler(){
	document.location.href="connexion.html"; 
}

function postUserBdd(name, role, email, pwd) {
    postUserGeneric(name, role, email, pwd, "v1/user/");
}

function postUserGeneric(name, role, email, pwd, url) {
	
		
	
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : url,
		dataType : "json",
		data : JSON.stringify({
			"name" : name,
			"role" : role,
			"email" : email,
			"password" : pwd,
			"id" : 0
		}),
		success : function(data, textStatus, jqXHR) {
			document.location.href="connexion.html"; 
			afficheUser(data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			$('#error').show();
			console.log('postUser error: ' + textStatus);
		}
	});
}

function postFournisseurBdd(nom, foc, adresse, ville,typem,statut,diplome,anneeExperience,heuresSemaine,mail,telephone,mdp) {
	console.log("foc : "+foc);	
    postFournniseurGeneric(nom, foc, adresse, ville,typem,statut,diplome,anneeExperience,heuresSemaine,mail,telephone,mdp,"v1/associe/");
}


function postFournniseurGeneric(nom, foc, adresse, ville,typem,statut,diplome,anneeExperience,heuresSemaine,mail,telephone,mdp,url) {
console.log("type:"+type);
console.log("telephone:"+telephone);
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : url,
		dataType : "json",
		data : JSON.stringify({
			"nom" : nom,
			"foc" : foc,
			"adresse" : adresse,
			"ville" : ville,
			"type" : typem,
			"statut" : statut,
			"diplome" : diplome,
			"annexp" : anneeExperience,
			"heuresSemaine" : heuresSemaine,
			"mail" : mail,
			"telephone" : telephone,
			"valide" : 0
					}),
		success : function(data, textStatus, jqXHR) {
			console.log(data.foc+" foc");
			postUserBdd(nom, foc, mail, mdp);
			afficheUser(data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			$('#error').show();
			console.log('postFournisseur error: ' + textStatus);
		}
	});
}

function listUsersBdd() {
    listUsersGeneric("v1/user/");
}

function listUsersGeneric(url) {
	$.getJSON(url, function(data) {
		afficheListUsers(data)
	});
}

function afficheUser(data) {
	console.log(data);
	
}

function afficheListUsers(data) {
	var html = '<ul>';
	var index = 0;
	for (index = 0; index < data.length; ++index) {
		html = html + "<li>"+ data[index].name + "</li>";
		}
}

function listOnlyUsersBdd() {
	listOnlyUsersGeneric("v1/user/");
}

function listOnlyUsersGeneric(url) {
	$.getJSON(url, function(data) {
		afficheOnlyUsers(data)
		});
}


function afficheOnlyUsers(data) {
	var html = '<h1>Utilisateur</h1><table><tr><th>Nom</th><th>Email</th></tr>';
	var js = "<script>$(document).ready(function() {";
	var index = 0;
	for (index = 0; index < data.length; ++index) {
		if(data[index].role=="user"){
			html = html + "<tr>";
			html = html + "<td>"+ data[index].name + "</td>";
			html = html + "<td>"+ data[index].email + "</td>";
			html = html + "<td><button type=\"button\" id=\"delete-user"+index+"\" class=\"delete\">Supprimer</button></td>";
			html = html + "</tr>";
			//correct 
			js+= "$(\"#delete-user"+index+"\").click(function(){" +
				"if (confirm(\"Êtes-vous certain de vouloir supprimer l'utilisateur "+data[index].name+" ?\") == true){"+
					"$.ajax({"+ 
					 "type : \'DELETE\',"+
					 "contentType : \'application/json\',"+
					 "url : \"v1/user/"+data[index].email+"\","+
					 "dataType : \"json\","+
					 "data : JSON.stringify({ \"email\" :\""+ data[index].email+"\" }),"+
					 "success : function(data, textStatus, jqXHR) {"+
					 "listOnlyUsersBdd();"+
					 "},"+
					 "error : function(jqXHR, textStatus, errorThrown) {"+
					 "}"+
					 "})"+
				"}"+
			     "});";
								 
			
			}
		}
	$("#reponse").html(html+"</table>");
	js+= "});  </script>";
	$("#test").html(js);
	}




function listOnlyFournisseurBdd(foc) {
	console.log("ok "+foc);
	listOnlyFournisseurGeneric("v1/associe/",foc);
}

function listOnlyFournisseurGeneric(url,foc) {
	$.getJSON(url, function(data) {
		afficheOnlyFournisseur(data,foc);
		});
}

function afficheOnlyFournisseur(data,foc) {
	var html;
	if(foc=="fournisseur"){
		html='<h1>Fournisseur</h1>';
		html+='<table><tr><th>Nom</th><th>Adresse</th><th>ville</th><th>Type de métier</th><th>Statut</th><th>Année d\'expérience</th><th>Mail</th><th>Telephone</th></tr>';
	}
	else{
		html='<h1>Collaborateur</h1>';
		html+='<table><tr><th>Nom</th><th>Adresse</th><th>ville</th><th>Type de métier</th><th>Statut</th><th>Diplôme</th><th>Année d\'expérience</th><th>Heure par semaine</th><th>Mail</th><th>Telephone</th></tr>';
	}

	

	var js = "<script>$(document).ready(function() {";
	var index = 0;
	for (index = 0; index < data.length; ++index) {
		if(data[index].foc==foc && data[index].valide!=0){
				 html+="<tr>";
    			 html+="<td>"+data[index].nom+"</td>";
              	 html+="<td>"+data[index].adresse+"</td>";
              	 html+="<td>"+data[index].ville+"</td>";
              	 html+="<td>"+data[index].type+"</td>";
              	 html+="<td>"+data[index].statut+"</td>";
              	 if(foc=="collaborateur"){
   		           	 html+="<td>"+data[index].diplome+"</td>";
        		}
        		 html+="<td>"+data[index].annexp+"</td>";
        		 if(foc=="collaborateur"){
   		           	 html+="<td>"+data[index].heuresSemaine+"</td>";
        		}
              	 html+="<td>"+data[index].mail+"</td>";
              	 html+="<td>"+data[index].telephone+"</td>";
              	 html+="<td><button type=\"button\" id=\"delete-four"+index+"\" class=\"delete\">Supprimer</button></td>";

			js+= "$(\"#delete-four"+index+"\").click(function(){" +
				"if (confirm(\"Êtes-vous certain de vouloir supprimer l'utilisateur "+data[index].nom+" ?\") == true){"+
					"$.ajax({"+ 
					 "type : \'DELETE\',"+
					 "contentType : \'application/json\',"+
					 "url : \"v1/associe/"+data[index].nom+"\","+
					 "dataType : \"json\","+
					 "data : JSON.stringify({ \"nom\" :\""+ data[index].nom+"\" }),"+
					 "success : function(data, textStatus, jqXHR) {";
					 if(foc=="fournisseur"){
						 js+="listOnlyFournisseurBdd(\"fournisseur\");";
					}
					else{
						js+="listOnlyFournisseurBdd(\"collaborateur\");";
					}
					 js+="},"+
					 "error : function(jqXHR, textStatus, errorThrown) {"+
					 "}"+
					 "})"+
				  "}"+
				"});";
			}
		}
	$("#reponse").html(html+"</table>");
	js+= "});  </script>";
	$("#test").html(js);
}


function displayNotif() {
	$.getJSON("v1/associe/", function(data) {
		displayNotification(data);
		});
}

function displayNotification(data){
    var html = "<h1>liste des notifications</h1>";
    var js = "<script>$(document).ready(function() {";
    html+= "<table><tr><th>nom</th><th>rôle</th><th>adresse</th><th>ville</th><th>type de métier</th><th>statut</th><th>diplôme</th><th>anéée d'expérience</th>";
    html+= "<th>heure par semaine</th> <th>email</th> <th>telephone</th></tr>";
   		 for (index = 0; index < data.length; ++index) {
   			if(data[index].valide==0){
   				 html+="<tr>";
    			 html+="<td>"+data[index].nom+"</td>";
              	 html+="<td>"+data[index].foc+"</td>";
              	 html+="<td>"+data[index].adresse+"</td>";
              	 html+="<td>"+data[index].ville+"</td>";
              	 html+="<td>"+data[index].type+"</td>";
              	 html+="<td>"+data[index].statut+"</td>";
              	 html+="<td>"+data[index].diplome+"</td>";
              	 html+="<td>"+data[index].annexp+"</td>";
              	 html+="<td>"+data[index].heuresSemaine+"</td>";
              	 html+="<td>"+data[index].mail+"</td>";
              	 html+="<td>"+data[index].telephone+"</td>";



				html = html + "<td><button type=\"button\" id=\"valide-foc"+index+"\" class=\"delete\">Valider</button></td>";
              	html = html + "<td><button type=\"button\" id=\"delete-foc"+index+"\" class=\"delete\">Supprimer</button></td>";

			    html = html + "</tr>";
				js+= "$(\"#delete-foc"+index+"\").click(function(){" +
				"if (confirm(\"Êtes-vous certain de vouloir supprimer l'utilisateur "+data[index].nom+" ?\") == true){"+
					"$.ajax({"+ 
					 "type : \'DELETE\',"+
					 "contentType : \'application/json\',"+
					 "url : \"v1/associe/"+data[index].nom+"\","+
					 "dataType : \"json\","+
					 "data : JSON.stringify({ \"nom\" :\""+ data[index].nom+"\" }),"+
					 "success : function(data, textStatus, jqXHR) {"+
					 "displayNotif();"+
					 "},"+
					 "error : function(jqXHR, textStatus, errorThrown) {"+
					 "}"+
					 "})"+
				  "}"+
				"});";

				js+= "$(\"#valide-foc"+index+"\").click(function(){" +
				"if (confirm(\"Êtes-vous certain de vouloir valider l'utilisateur "+data[index].nom+" ?\") == true){"+
					"$.ajax({"+ 
					 "type : \'PUT\',"+
					 "contentType : \'application/json\',"+
					 "url : \"v1/associe/"+data[index].nom+"\","+
					 "dataType : \"json\","+
					 //"data : JSON.stringify({ \"nom\" :\""+ data[index].nom+"\" }),"+
					 "success : function(data, textStatus, jqXHR) {"+
					 "displayNotif();"+
					 "},"+
					 "error : function(jqXHR, textStatus, errorThrown) {"+
					 "}"+
					 "})"+
				  "}"+
				"});";

              	}
              }
             
	$("#reponse").html(html);
	js+= "});  </script>";
	$("#test").html(js);
}

function listerCommandesAdmin(){
	
}
