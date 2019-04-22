pragma solidity^0.5.1;

library SafeMath {
  function add(uint256 a, uint256 b) public pure returns (uint256 c) {
    c = a + b;
    assert(c >= a);
    return c;
  }

function mul(uint256 a, uint256 b) internal pure returns (uint256 c) {
  if (a == 0) {
    return 0;
  }
  c = a * b;
  assert(c / a == b);
    return c;
  }
}

contract Mallory {
  SimpleDAO dao;
  testContract test;
  mapping (address => uint) userBalance;

  function func() public {
    dao.withdraw();
  }
  function() external { 
    //dao.withdraw();
  }
  function testFunc() public {
    //dao.withdraw();
    //func();
   test.testFunc2();
  }
  function notitle() public {
      dao.withdraw();
  }
  function getBalance(address u) public view returns(uint){
    return userBalance[u];
  }
}
 
contract SimpleDAO {
  Mallory mallory;
  mapping (address => uint) public credit;

  function withdraw() public {
    Mallory mal;
    address adrr;
    mallory.testFunc(); 
    mal.func();
    adrr = tx.origin;
  }
}

contract testContract {
  SimpleDAO simple;
  function testFunc2() public {
      simple.withdraw();
  }
}