package com.wong.config;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.wong.pojo.User;
import com.wong.service.UserService;

//自定義的UserRealm
public class UserRealm extends AuthorizingRealm {

  @Autowired
  UserService userService;
  
  //授權
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
      System.out.println("執行了=>授權doGetAuthorizationInfo");

      SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
      // 所有用戶都有權限訪問 add，不設限，我們應該根據數據庫中權限設定來判斷誰有權限訪問 add
//      info.addStringPermission("user:add");

      //拿到當前登錄的這個對象
      Subject subject = SecurityUtils.getSubject();
      User currentUser = (User)subject.getPrincipal();//拿到user對象

      //設置當前用戶的權限
      info.addStringPermission(currentUser.getPerms());

      return info;
//      return null;
  }

  //認證
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
      System.out.println("執行了=>認證doGetAuthorizationInfo");

//      // 虛擬用戶
//      String name = "root";
//      String password = "123456";
//      
      UsernamePasswordToken userToken = (UsernamePasswordToken) token;
//      if (!userToken.getUsername().equals(name)) {
//       return null;//拋出異常 UnknownAccountException
//      }

      // 真實數據庫 用戶名、密碼， 數據中取
      User user = userService.queryUserByName(userToken.getUsername());

      if (user == null) {//沒有這個人
          return null;
      }

      // 首頁
      Subject currentSubject = SecurityUtils.getSubject();
      Session session = currentSubject.getSession();
      session.setAttribute("loginUser",user);


      // 密碼認證，shiro做，加密了，可看源碼debug
//      return new SimpleAuthenticationInfo("",password,""); // for虛擬用戶
      return new SimpleAuthenticationInfo(user,user.getPwd(),""); // for真實數據庫
      
//      return null;
  }
}