  
import React from 'react';
import {useState,Component} from 'react';
import {AppRegistry , StyleSheet,TextInput ,Button ,FlatList ,Image,  Text,View,
     ActivityIndicator, Linking, Touchable} from 'react-native';





export default class ProdList extends React.Component {


  constructor(){
    super();
    
    this.state = {
      prodsData: []
    }
  }
  sayHello() {
    alert('Hello!');
  }

  componentDidMount(){
    const url="https://api.imgflip.com/get_memes";
    fetch(url)
    .then((response) => response.json())
    .then((responseJson) => {
        this.setState({
          prodsData : responseJson.data.memes
        })
    })
    .catch((error) => {
      console.log(error)
    })

  }
  
  renderItem = ({item}) => {
    
   //const {navigate} = this.props.navigation;
   
   
    return (
      <View style={{alignItems:"center", backgroundColor:"gray",padding:20,margin:1}}>
      <Text style={{fontWeight:'bold', fontSize:30}}>
        TITLE
      </Text>
      <Text  style={{fontWeight:'bold',fontSize:20}}>
            {item.name}
          </Text>
        <Image style={{alignContent:"center", width: 300, height:300 ,marginLeft:40}}
            source={{uri : item.url}}/>
      
          
         <View style={{flex:2}}>
            <Text style={{fontSize:15}}>
                <Button title='View Details' onPress={()=>{Linking.openURL("https://www.accolite.com/")}} />
                 
                
              </Text>
          </View>
        
    </View>

    )
    

  }

  
  
  render(){
  
        const text="search";
    
    
        return (


        <View style={{alignContent:'center'}}>    
            {console.log(this.state.prodsData)}
            <FlatList
            data={this.state.prodsData}
            renderItem={this.renderItem}
            />
        </View>
        )
        
    }
}

AppRegistry.registerComponent('Native-app', () => ProdList);

