import requests
from datetime import datetime
class ScoreGet:
    def __init__(self):
        self.url_get_all_matches = "http://cricapi.com/api/matches"
        self.url_get_score="http://cricapi.com/api/cricketScore"
        self.api_key = "sGtRx1I5PShviKaCNl2v0CR5ndm1"
        self.unique_id = ""
    def get_unique_id(self,country):
        
        uri_params = {"apikey": self.api_key} #Selecting parameter for request
        resp = requests.get(self.url_get_all_matches, params=uri_params)
        resp_dict = resp.json()
        uid_found=0
        for i in resp_dict['matches']:
            if (i['team-1'] == country or i['team-2'] == country) and i['matchStarted']:
                uid_found=1
                self.unique_id=i['unique_id']
                break
        if not uid_found:
            self.unique_id=-1



        send_data=self.get_score(self.unique_id)
        return send_data
    def get_score(self,unique_id):
        print("The Match id : " + str(self.unique_id))
        data="" 
        if unique_id == -1:
            data="No matches today"
        else:
            uri_params = {"apikey": self.api_key, "unique_id": self.unique_id}
            resp=requests.get(self.url_get_score,params=uri_params)
            data_json=resp.json()
            #print(data_json)
            try:
                data="Here's the score : "+ "\n" + data_json['stat'] +'\n' + data_json['score']
            except KeyError as e:
                
                data="Something went wrong"
                print(e)
        return data

if __name__ == "__main__":
    print("Welcome to cricket world!!")
    match_object = ScoreGet()
    TeamName    = input("Enter Country Name ")
    print(match_object.get_unique_id(TeamName))


