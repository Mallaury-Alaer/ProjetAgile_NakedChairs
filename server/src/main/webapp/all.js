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
	console.log("postUserGeneric " + url)
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

function postFournisseurBdd(nom, foc, adresse, ville,type,statut,diplôme,anneeExperience,heuresSemaine,email,telephone,mdp) {
    postFournniseurGeneric(nom, foc, adresse, ville,type,statut,diplôme,anneeExperience,heuresSemaine,email,telephone,mdp,"v1/associe/");
}


function postFournniseurGeneric(nom, foc, adresse, ville,type,statut,diplôme,anneeExperience,heuresSemaine,email,telephone,mdp,url) {
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
			"type" : type,
			"statut" : statut,
			"diplôme" : diplôme,
			"anneeExperience" : anneeExperience,
			"heuresSemaine" : heuresSemaine,
			"email" : email,
			"telephone" : telephone,
			"valide" : 0
					}),
		success : function(data, textStatus, jqXHR) {
			console.log(data);
			postUserBdd(nom, foc, email, mdp);
			afficheUser(data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			$('#error').show();
			console.log('postUser error: ' + textStatus);
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
								 
				//console.log(js);
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
	var html = '<h1>Fournisseur</h1><table><tr><th>Nom</th><th>Email</th><th>Fournis</th></tr>';
	var js = "<script>$(document).ready(function() {";
	var index = 0;
	for (index = 0; index < data.length; ++index) {
		if(data[index].foc==foc){
			html = html + "<tr>";
			html = html + "<td>"+ data[index].name + "</td>";
			html = html + "<td>"+ data[index].email + "</td>";
			html = html + "<td>nothing</td>";
			html = html + "<td><button type=\"button\" id=\"delete-user"+index+"\" class=\"delete\">Supprimer</button></td>";
			html = html + "</tr>";
			js+= "$(\"#delete-user"+index+"\").click(function(){" +
				"if (confirm(\"Êtes-vous certain de vouloir supprimer l'utilisateur "+data[index].name+" ?\") == true){"+
					"$.ajax({"+ 
					 "type : \'DELETE\',"+
					 "contentType : \'application/json\',"+
					 "url : \"v1/associe/"+data[index].email+"\","+
					 "dataType : \"json\","+
					 "data : JSON.stringify({ \"email\" :\""+ data[index].email+"\" }),"+
					 "success : function(data, textStatus, jqXHR) {"+
					 "listOnlyFournisseurBdd();"+
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
              	 html+="<td>"+data[index].diplôme+"</td>";
              	 html+="<td>"+data[index].anneeExperience+"</td>";
              	 html+="<td>"+data[index].heuresSemaine+"</td>";
              	 html+="<td>"+data[index].email+"</td>";
              	 html+="<td>"+data[index].telephone+"</td></tr>";




              	 js+= "$(\"#delete-user"+index+"\").click(function(){" +
				"if (confirm(\"Êtes-vous certain de vouloir supprimer l'utilisateur "+data[index].nom+" ?\") == true){"+
					"$.ajax({"+ 
					 "type : \'DELETE\',"+
					 "contentType : \'application/json\',"+
					 "url : \"v1/associe/"+data[index].email+"\","+
					 "dataType : \"json\","+
					 "data : JSON.stringify({ \"email\" :\""+ data[index].nom+"\" }),"+
					 "success : function(data, textStatus, jqXHR) {"+
					 "listOnlyFournisseurBdd();"+
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


