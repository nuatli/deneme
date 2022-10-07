import {connect} from 'react-redux';
import {bindActionCreators} from 'redux';
import TopBar from '../components/TopBar';
import {logoutSuccess} from '../actions/authActions';

const mapStateToProps = (reduxState) => {
	return{
		isLoggedIn:reduxState.authReducer.isLoggedIn,
		username:reduxState.authReducer.username
	}
}

const mapDispatchToProps = dispatch => {
	return{
		onLogoutSuccess:() => dispatch(logoutSuccess())
	}
}

export default connect(mapStateToProps,mapDispatchToProps)(TopBar);