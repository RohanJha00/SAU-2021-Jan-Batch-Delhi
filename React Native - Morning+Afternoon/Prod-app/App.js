// import { StatusBar } from 'expo-status-bar';
// import React from 'react';
// import { StyleSheet, Text, View } from 'react-native';

// export default function App() {
//   return (
//     <View style={styles.container}>
//       <Text>Open up App.js to start working on your app!</Text>
//       <StatusBar style="auto" />
//     </View>
//   );
// }

// const styles = StyleSheet.create({
//   container: {
//     flex: 1,
//     backgroundColor: '#fff',
//     alignItems: 'center',
//     justifyContent: 'center',
//   },
// });

import React, { Component } from 'react';  
import { Platform, StyleSheet, View, Text,  
Image, TouchableOpacity, Alert } from 'react-native'; 
 
import ProdList from './components/ProdList'; 
 export default class Myapp extends Component  
{  
   constructor(){  
     super();  
     this.state={  
     isVisible : true,  
    }  
  }  
   Hide_Splash_Screen=()=>{  
    this.setState({   
      isVisible : false   
    });  
  }  
   
  componentDidMount(){  
    var that = this;  
    setTimeout(function(){  
      that.Hide_Splash_Screen();  
    }, 5000);  
   }  
   
    render()  
    {  
        let Splash_Screen = (  
             <View style={styles.SplashScreen_RootView}>  
                 <View style={styles.SplashScreen_ChildView}>  
                       <Image source={require('./assets/icon.png')}  
                    style={{width:'10%', height: '10%', resizeMode: 'contain'}} />  
                    <Text style={{fontSize:30,textAlign: 'center',color:'white'}}>Products Listing App</Text>
                </View>  
             </View> )  
         return(  
             <View style = { styles.MainContainer }>  
                {/* <Text style={{textAlign: 'center'}}> Splash Screen Example</Text>   */}
                <ProdList></ProdList>
                 {  
                  (this.state.isVisible === true) ? Splash_Screen : null  
                }  
            </View>  
              );  
    }  
}  
 const styles = StyleSheet.create(  
{  
    MainContainer:  
    {  
        flex: 1,  
        justifyContent: 'center',  
        alignItems: 'center',
        backgroundColor: '#4F6D7A',  
        paddingTop: ( Platform.OS === 'ios' ) ? 20 : 0  
    },  
   
    SplashScreen_RootView:  
    {  
        justifyContent: 'center',  
        flex:1,  
        margin: 10,  
        position: 'absolute',  
        width: '100%',  
        height: '100%',  
      },  
   
    SplashScreen_ChildView:  
    {  
        // fontSize: 0.4,
        flex:1, 
        justifyContent: 'center',  
        alignItems: 'center',  
        backgroundColor: '#4F6D7A',   
    },  
});  