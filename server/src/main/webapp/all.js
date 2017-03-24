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
				"});";
								 
				//console.log(js);
			}
		}
	$("#reponse").html(html+"</table>");
	js+= "});  </script>";
	$("#test").html(js);
	}




function listOnlyFournisseurBdd() {
	listOnlyFournisseurGeneric("v1/user/");
}

function listOnlyFournisseurGeneric(url) {
	$.getJSON(url, function(data) {
		afficheOnlyFournisseur(data)
		});
}

function afficheOnlyFournisseur(data) {
	var html = '<h1>Fournisseur</h1><table><tr><th>Nom</th><th>Email</th><th>Fournis</th></tr>';
	var js = "<script>$(document).ready(function() {";
	var index = 0;
	for (index = 0; index < data.length; ++index) {
		if(data[index].role=="fournisseur"){
			html = html + "<tr>";
			html = html + "<td>"+ data[index].name + "</td>";
			html = html + "<td>"+ data[index].email + "</td>";
			html = html + "<td>nothing</td>";
			html = html + "<td><button type=\"button\" id=\"delete-user"+index+"\" class=\"delete\">Supprimer</button></td>";
			html = html + "</tr>";
			js+= "$(\"#delete-user"+index+"\").click(function(){" +
					"$.ajax({"+ 
					 "type : \'DELETE\',"+
					 "contentType : \'application/json\',"+
					 "url : \"v1/user/"+data[index].email+"\","+
					 "dataType : \"json\","+
					 "data : JSON.stringify({ \"email\" :\""+ data[index].email+"\" }),"+
					 "success : function(data, textStatus, jqXHR) {"+
					 "listOnlyFournisseurBdd();"+
					 "},"+
					 "error : function(jqXHR, textStatus, errorThrown) {"+
					 "}"+
					 "})"+
				"});";
			}
		}
	$("#reponse").html(html+"</table>");
	js+= "});  </script>";
	$("#test").html(js);
}

