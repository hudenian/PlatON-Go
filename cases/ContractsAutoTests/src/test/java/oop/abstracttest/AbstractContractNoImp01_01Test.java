package oop.abstracttest;

import network.platon.autotest.junit.annotations.DataSource;
import network.platon.autotest.junit.enums.DataSourceType;
import network.platon.autotest.junit.rules.AssertCollector;
import network.platon.autotest.junit.rules.DriverService;
import network.platon.contracts.AbstractContractGrandpa;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;

/**
 * @title 1、抽象合约未实现任何方法，验证是否可编译、部署、执行
 * @description:
 * @author: qudong
 * @create: 2019/12/25 15:09
 **/
public class AbstractContractNoImp01_01Test {
    @Rule
    public AssertCollector collector = new AssertCollector();

    @Rule
    public DriverService driverService = new DriverService();

    // 底层链ID
    private long chainId;

    @Before
    public void before() {
        chainId = Integer.valueOf(driverService.param.get("chainId"));
    }

    @Test
    @DataSource(type = DataSourceType.EXCEL, file = "test.xls", author = "qudong", showName = "01AbstractContractExecuteTest_01.验证抽象合约(未实现任何抽象方法)是否可以编译部署执行")
    public void testAbstractContract() {
        Web3j web3j = null;
        Credentials credentials = null;
        try {
            web3j = Web3j.build(new HttpService(driverService.param.get("nodeUrl")));
            credentials = Credentials.create(driverService.param.get("privateKey"));
            collector.logStepPass("initCurrentBlockNumber:" + web3j.platonBlockNumber().send().getBlockNumber());
        } catch (Exception e) {
            collector.logStepFail("The node is unable to connect", e.toString());
            e.printStackTrace();
        }


        ContractGasProvider provider = new ContractGasProvider(new BigInteger("50000000000"), new BigInteger("3000000"));
        RawTransactionManager transactionManager = new RawTransactionManager(web3j, credentials, chainId);

        //1、合约部署
        String contractAddress = "";
        try {
            AbstractContractGrandpa grandpaAbstractContract = AbstractContractGrandpa.deploy(web3j, transactionManager, provider).send();
            contractAddress = grandpaAbstractContract.getContractAddress();
            TransactionReceipt tx = grandpaAbstractContract.getTransactionReceipt().get();

            collector.logStepPass("AbstractContract issued successfully.contractAddress:" + contractAddress
                                 + ", hash:" + tx.getTransactionHash());

            //collector.assertEqual(tokenName, token.name().send(), "checkout tokenName");
            collector.logStepPass("deployFinishCurrentBlockNumber:" + tx.getBlockNumber());

        } catch (Exception e) {
            collector.logStepFail("grandpaAbstractContract deploy fail.", e.toString());
            e.printStackTrace();
        }

        //2、调用合约方法
        try{
            String name = AbstractContractGrandpa.load(contractAddress, web3j, transactionManager, provider)
                          .name().send();
            collector.logStepFail("grandpaAbstractContract Calling Method Fail.","抽象合约是无法执行方法的");
        }catch (Exception e){
            collector.logStepPass("调用合约方法getName()完毕,无法执行抽象合约方法," + e.getMessage());
            collector.assertEqual(e.getMessage(),"Empty value (0x) returned from contract","checkout  execute success.");
            //e.printStackTrace();
        }





    }

}