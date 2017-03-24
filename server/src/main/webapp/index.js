var liste [] = {'idx', 'abtus', 'blg', 'connexion', 'inscr'};
var affiche = function affiche(name){
    for(var i = 0; i<=liste.length; i++){
        if(!liste[i].equals(name))
            document.getElementsByClassName(liste[i]).style.display = "none";
    }
    document.getElementsByClassName(name).style.display = "block";
}

 //<img id="imgBergere3" src="ressources/images-chaises/Bergere-Jacob-Louis-XV.jpeg" alt="Bergère 3" height=120px onclick="imgSecondaires(this.id)">