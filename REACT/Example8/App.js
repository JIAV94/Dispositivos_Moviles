import React from 'react';
import { StyleSheet, Text, View, Image } from 'react-native';

export default class App extends React.Component {
  render() {
  	let pic = {
  		uri:'https://pbs.twimg.com/media/DAcgrJGXgAAGH2p.png',
  		width: 180, 
  		height: 350
  	};
    return (
      <View style={styles.container}>
        <Text>Nionic</Text>
        <Image source={pic}/>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
