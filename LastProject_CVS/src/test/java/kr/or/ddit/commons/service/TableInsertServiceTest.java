package kr.or.ddit.commons.service;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.model.BarcodeVo;
import kr.or.ddit.model.CategoryVo;
import kr.or.ddit.model.CvsServiceVo;
import kr.or.ddit.model.StockListVo;
import kr.or.ddit.model.StockVo;
import kr.or.ddit.model.SupplyListVo;
import kr.or.ddit.model.SupplyVo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml",
		 "classpath:kr/or/ddit/config/spring/transaction.xml",
		 "classpath:kr/or/ddit/config/spring/datasource.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TableInsertServiceTest {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;
	
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate  auto;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
//	@Test
	public void bean() {
		assertNotNull(auto);
		assertNotNull(dao);
	}
	
	public String bar(String code){
		return auto.barcode(code); 
	}
	
	public String bar(String code, String mem_id){
		return auto.autoCode(code, mem_id); 
	}
	
//	@Test
//	public void supplyInsert(){
//		
////		int resultB = 0;
////		int resultS = 0;
//		int resultSL = 0;
//		// 기초 데이터
////		String barCode = bar("SUPPLY");
////		String barCode = "SUPPLY-e05f3b96-0386-43b8-881d-c3db718700c9";
////		String date = "2018-09-18";
////		String mem_id = "6510000-104-2015-00153";//노호려_제주
//		String[] prod_id = {"biscuit-00443","biscuit-00123","biscuit-00884","biscuit-00665","biscuit-00929","biscuit-00659","biscuit-00864"
//				,"necessities-00001"
//				,"necessities-00002"
//				,"necessities-00003"
//				,"necessities-00004"
//				,"necessities-00005"
//				,"necessities-00006"
//				,"necessities-00007"
//				,"necessities-00008"
//				,"necessities-00009"
//				,"necessities-00010"
//				,"necessities-00011"
//				,"necessities-00012"
//				,"necessities-00013"
//				,"necessities-00014"
//				,"necessities-00015"
//				,"necessities-00016"
//				,"necessities-00017"
//				,"necessities-00018"
//				,"necessities-00019"
//				,"necessities-00020"
//				,"necessities-00021"
//				,"necessities-00022"
//				,"necessities-00023"
//				,"necessities-00024"
//				,"necessities-00025"
//				,"necessities-00026"
//				,"necessities-00027"
//				,"necessities-00028"
//				,"necessities-00029"
//				,"necessities-00030"
//				,"necessities-00031"
//				,"necessities-00032"
//				,"necessities-00033"
//				,"necessities-00034"
//				,"necessities-00035"
//				,"necessities-00036"
//				,"necessities-00037"
//				,"necessities-00038"
//				,"necessities-00039"
//				,"necessities-00040"
//				,"necessities-00041"
//				,"necessities-00042"
//				,"necessities-00043"
//				,"necessities-00044"
//				,"necessities-00045"
//				,"necessities-00046"
//				,"necessities-00047"
//				,"necessities-00048"
//				,"necessities-00049"
//				,"necessities-00050"
//				,"necessities-00051"
//				,"necessities-00052"
//				,"necessities-00053"
//				,"necessities-00054"
//				,"necessities-00055"
//				,"necessities-00056"
//				,"necessities-00057"
//				,"necessities-00058"
//				,"necessities-00059"
//				,"necessities-00060"
//				,"necessities-00061"
//				,"necessities-00062"
//				,"necessities-00063"
//				,"necessities-00064"
//				,"necessities-00065"
//				,"necessities-00066"
//				,"necessities-00067"
//				,"necessities-00068"
//				,"necessities-00069"
//				,"necessities-00070"
//				,"necessities-00071"
//				,"necessities-00072"
//				,"necessities-00073"
//				,"necessities-00074"
//				,"necessities-00075"
//				,"necessities-00076"
//				,"necessities-00077"
//				,"necessities-00078"
//				,"necessities-00079"
//				,"necessities-00080"
//				,"necessities-00081"
//				,"necessities-00082"
//				,"necessities-00083"
//				,"necessities-00084"
//				,"necessities-00085"
//				,"necessities-00086"
//				,"necessities-00087"
//				,"necessities-00088"
//				,"necessities-00089"
//				,"necessities-00090"
//				,"necessities-00091"
//				,"necessities-00092"
//				,"necessities-00093"
//				,"necessities-00094"
//				,"necessities-00095"
//				,"necessities-00096"
//				,"necessities-00097"
//				,"necessities-00098"
//				,"necessities-00099"
//				,"necessities-00100"
//				,"necessities-00101"
//				,"necessities-00102"
//				,"necessities-00103"
//				,"necessities-00104"
//				,"necessities-00105"
//				,"necessities-00106"
//				,"necessities-00107"
//				,"necessities-00108"
//				,"necessities-00109"
//				,"necessities-00110"
//				,"necessities-00111"
//				,"necessities-00112"
//				,"necessities-00113"
//				,"necessities-00114"
//				,"necessities-00115"
//				,"necessities-00116"
//				,"necessities-00117"
//				,"necessities-00118"
//				,"necessities-00119"
//				,"necessities-00120"
//				,"necessities-00121"
//				,"necessities-00122"
//				,"necessities-00123"
//				,"necessities-00124"
//				,"necessities-00125"
//				,"necessities-00126"
//				,"necessities-00127"
//				,"necessities-00128"
//				,"necessities-00129"
//				,"necessities-00130"
//				,"necessities-00131"
//				,"necessities-00132"
//				,"necessities-00133"
//				,"necessities-00134"
//				,"necessities-00135"
//				,"necessities-00136"
//				,"necessities-00137"
//				,"necessities-00138"
//				,"necessities-00139"
//				,"necessities-00140"
//				,"necessities-00141"
//				,"necessities-00142"
//				,"necessities-00143"
//				,"necessities-00144"
//				,"necessities-00145"
//				,"necessities-00146"
//				,"necessities-00147"
//				,"necessities-00148"
//				,"food-00001"
//				,"food-00002"
//				,"food-00003"
//				,"food-00004"
//				,"food-00005"
//				,"food-00006"
//				,"food-00007"
//				,"food-00008"
//				,"food-00009"
//				,"food-00010"
//				,"food-00011"
//				,"food-00012"
//				,"food-00013"
//				,"food-00014"
//				,"food-00015"
//				,"food-00016"
//				,"food-00017"
//				,"food-00018"
//				,"food-00019"
//				,"food-00020"
//				,"food-00021"
//				,"food-00022"
//				,"food-00023"
//				,"food-00024"
//				,"food-00025"
//				,"food-00026"
//				,"food-00027"
//				,"food-00028"
//				,"food-00029"
//				,"food-00030"
//				,"food-00031"
//				,"food-00032"
//				,"food-00033"
//				,"food-00034"
//				,"food-00035"
//				,"food-00036"
//				,"food-00037"
//				,"food-00038"
//				,"food-00039"
//				,"food-00040"
//				,"food-00041"
//				,"food-00042"
//				,"food-00043"
//				,"food-00044"
//				,"food-00045"
//				,"food-00046"
//				,"food-00047"
//				,"food-00048"
//				,"food-00049"
//				,"food-00050"
//				,"food-00051"
//				,"food-00052"
//				,"food-00053"
//				,"food-00054"
//				,"food-00055"
//				,"food-00056"
//				,"food-00057"
//				,"food-00058"
//				,"food-00059"
//				,"food-00060"
//				,"food-00061"
//				,"food-00062"
//				,"food-00063"
//				,"food-00064"
//				,"food-00065"
//				,"food-00066"
//				,"food-00067"
//				,"food-00068"
//				,"food-00069"
//				,"food-00070"
//				,"food-00071"
//				,"food-00072"
//				,"food-00073"
//				,"food-00074"
//				,"food-00075"
//				,"food-00076"
//				,"food-00077"
//				,"food-00078"
//				,"food-00079"
//				,"food-00080"
//				,"food-00081"
//				,"food-00082"
//				,"food-00083"
//				,"food-00084"
//				,"food-00085"
//				,"food-00086"
//				,"food-00087"
//				,"food-00088"
//				,"food-00089"
//				,"food-00090"
//				,"food-00091"
//				,"food-00092"
//				,"food-00093"
//				,"food-00094"
//				,"food-00095"
//				,"food-00096"
//				,"food-00097"
//				,"food-00098"
//				,"food-00099"
//				,"food-00100"
//				,"food-00101"
//				,"food-00102"
//				,"food-00103"
//				,"food-00104"
//				,"food-00105"
//				,"food-00106"
//				,"food-00107"
//				,"food-00108"
//				,"food-00109"
//				,"food-00110"
//				,"food-00111"
//				,"food-00112"
//				,"food-00113"
//				,"food-00114"
//				,"food-00115"
//				,"food-00116"
//				,"food-00117"
//				,"food-00118"
//				,"food-00119"
//				,"food-00120"
//				,"food-00121"
//				,"food-00122"
//				,"food-00123"
//				,"food-00124"
//				,"food-00125"
//				,"food-00126"
//				,"food-00127"
//				,"food-00128"
//				,"food-00129"
//				,"food-00130"
//				,"food-00131"
//				,"food-00132"
//				,"food-00133"
//				,"food-00134"
//				,"food-00135"
//				,"food-00136"
//				,"food-00137"
//				,"food-00138"
//				,"food-00139"
//				,"food-00140"
//				,"food-00141"
//				,"food-00142"
//				,"food-00143"
//				,"food-00144"
//				,"food-00145"
//				,"food-00146"
//				,"food-00147"
//				,"food-00148"
//				,"food-00149"
//				,"food-00150"
//				,"food-00151"
//				,"food-00152"
//				,"food-00153"
//				,"food-00154"
//				,"food-00155"
//				,"food-00156"
//				,"food-00157"
//				,"food-00158"
//				,"food-00159"
//				,"food-00160"
//				,"food-00161"
//				,"food-00162"
//				,"food-00163"
//				,"food-00164"
//				,"food-00165"
//				,"food-00166"
//				,"food-00167"
//				,"food-00168"
//				,"food-00169"
//				,"food-00170"
//				,"food-00171"
//				,"food-00172"
//				,"food-00173"
//				,"food-00174"
//				,"food-00175"
//				,"food-00176"
//				,"food-00177"
//				,"food-00178"
//				,"food-00179"
//				,"food-00180"
//				,"food-00181"
//				,"food-00182"
//				,"food-00183"
//				,"food-00184"
//				,"food-00185"
//				,"food-00186"
//				,"food-00187"
//				,"food-00188"
//				,"food-00189"
//				,"drink-00540"
//				,"drink-00541"
//				,"drink-00542"
//				,"drink-00543"
//				,"drink-00544"
//				,"drink-00545"
//				,"drink-00546"
//				,"drink-00547"
//				,"drink-00548"
//				,"drink-00549"
//				,"drink-00550"
//				,"drink-00551"
//				,"drink-00552"
//				,"drink-00553"
//				,"drink-00554"
//				,"drink-00555"
//				,"drink-00556"
//				,"drink-00557"
//				,"drink-00558"
//				,"drink-00559"
//				,"drink-00560"
//				,"drink-00561"
//				,"drink-00562"
//				,"drink-00563"
//				,"drink-00564"
//				,"drink-00565"
//				,"drink-00566"
//				,"drink-00567"
//				,"drink-00568"
//				,"drink-00569"
//				,"drink-00570"
//				,"drink-00571"
//				,"drink-00572"
//				,"drink-00573"
//				,"drink-00574"
//				,"drink-00575"
//				,"drink-00576"
//				,"drink-00577"
//				,"drink-00578"
//				,"drink-00579"
//				,"drink-00580"
//				,"drink-00581"
//				,"drink-00582"
//				,"drink-00583"
//				,"drink-00584"
//				,"drink-00585"
//				,"drink-00586"
//				,"drink-00587"
//				,"drink-00588"
//				,"drink-00589"
//				,"drink-00590"
//				,"drink-00591"
//				,"drink-00592"
//				,"drink-00593"
//				,"drink-00594"
//				,"drink-00595"
//				,"drink-00596"
//				,"drink-00597"
//				,"drink-00598"
//				,"drink-00599"
//				,"drink-00600"
//				,"drink-00601"
//				,"drink-00602"
//				,"drink-00603"
//				,"drink-00604"
//				,"drink-00605"
//				,"drink-00606"
//				,"drink-00607"
//				,"drink-00608"
//				,"drink-00609"
//				,"drink-00610"
//				,"drink-00611"
//				,"drink-00612"
//				,"drink-00613"
//				,"drink-00614"
//				,"drink-00615"
//				,"drink-00616"
//				,"drink-00617"
//				,"drink-00618"
//				,"drink-00619"
//				,"drink-00620"
//				,"drink-00621"
//				,"drink-00622"
//				,"drink-00623"
//				,"drink-00624"
//				,"drink-00625"
//				,"drink-00626"
//				,"drink-00627"
//				,"drink-00628"
//				,"drink-00629"
//				,"drink-00630"
//				,"drink-00631"
//				,"drink-00632"
//				,"drink-00633"
//				,"drink-00634"
//				,"drink-00635"
//				,"drink-00636"
//				,"drink-00637"
//				,"drink-00638"
//				,"drink-00639"
//				,"drink-00640"
//				,"drink-00641"
//				,"drink-00642"
//				,"drink-00643"
//				,"drink-00644"
//				,"drink-00645"
//				,"drink-00646"
//				,"drink-00647"
//				,"drink-00648"
//				,"drink-00649"
//				,"drink-00650"
//				,"drink-00651"
//				,"drink-00652"
//				,"drink-00653"
//				,"drink-00654"
//				,"drink-00655"
//				,"drink-00656"
//				,"drink-00657"
//				,"drink-00658"
//				,"drink-00659"
//				,"drink-00660"
//				,"drink-00661"
//				,"drink-00662"
//				,"drink-00663"
//				,"drink-00664"
//				,"drink-00665"
//				,"drink-00666"
//				,"drink-00667"
//				,"drink-00668"
//				,"drink-00669"
//				,"drink-00670"
//				,"drink-00671"
//				,"drink-00672"
//				,"drink-00673"
//				,"drink-00674"
//				,"drink-00675"
//				,"drink-00676"
//				,"drink-00677"
//				,"drink-00678"
//				,"drink-00679"
//				,"drink-00680"
//				,"drink-00681"
//				,"drink-00682"
//				,"drink-00683"
//				,"drink-00684"
//				,"drink-00685"
//				,"drink-00686"
//				,"drink-00687"
//				,"drink-00688"
//				,"drink-00689"
//				,"drink-00690"
//				,"drink-00691"
//				,"drink-00692"
//				,"drink-00693"
//				,"drink-00694"
//				,"drink-00695"
//				,"drink-00696"
//				,"drink-00697"
//				,"drink-00698"
//				,"drink-00699"
//				,"drink-00700"
//				,"drink-00701"
//				,"drink-00702"
//				,"drink-00703"
//				,"drink-00704"
//				,"drink-00705"
//				,"drink-00706"
//				,"drink-00707"
//				,"drink-00708"
//				,"drink-00709"
//				,"drink-00710"
//				,"drink-00711"
//				,"drink-00712"
//				,"drink-00713"
//				,"drink-00714"
//				,"drink-00715"
//				,"drink-00716"
//				,"drink-00717"
//				,"drink-00718"
//				,"drink-00719"
//				,"food-00380"
//				,"food-00381"
//				,"food-00382"
//				,"food-00383"
//				,"food-00384"
//				,"food-00385"
//				,"food-00386"
//				,"food-00387"
//				,"food-00388"
//				,"food-00389"
//				,"food-00390"
//				,"food-00391"
//				,"food-00392"
//				,"food-00393"
//				,"food-00394"
//				,"food-00395"
//				,"food-00396"
//				,"food-00397"
//				,"food-00398"
//				,"food-00399"
//				,"food-00400"
//				,"food-00401"
//				,"food-00402"
//				,"food-00403"
//				,"food-00404"
//				,"food-00405"
//				,"food-00406"
//				,"food-00407"
//				,"food-00408"
//				,"food-00409"
//				,"food-00410"
//				,"food-00411"
//				,"food-00412"
//				,"food-00413"
//				,"food-00414"
//				,"food-00415"
//				,"food-00416"
//				,"food-00417"
//				,"food-00418"
//				,"food-00419"
//				,"food-00420"
//				,"food-00421"
//				,"food-00422"
//				,"food-00423"
//				,"food-00424"
//				,"food-00425"
//				,"food-00426"
//				,"food-00427"
//				,"food-00428"
//				,"food-00429"
//				,"food-00430"
//				,"food-00431"
//				,"food-00432"
//				,"food-00433"
//				,"food-00434"
//				,"food-00435"
//				,"food-00436"
//				,"food-00437"
//				,"food-00438"
//				,"food-00439"
//				,"food-00440"
//				,"food-00441"
//				,"food-00442"
//				,"food-00443"
//				,"food-00444"
//				,"food-00445"
//				,"food-00446"
//				,"food-00447"
//				,"food-00448"
//				,"food-00449"
//				,"food-00450"
//				,"food-00451"		
//		};
		
//		BarcodeVo bvo = new BarcodeVo();
//		bvo.setBcd_id(barCode);
////		bvo.setBcd_content("발주");
//		bvo.setBcd_kind("102");
//		bvo.setBcd_path("test중");
//
//		// 바코드 생성
//		resultB += dao.insert("tableInsert.barcodeInsert", bvo);
		
		// 발주 생성
//		SupplyVo svo = new SupplyVo();
//		svo.setSupply_bcd(barCode);
//		svo.setSupply_info(null);
//		svo.setSupply_state("10");
//		svo.setPlace_id(mem_id);	
//		svo.setSupply_date(date);
//		resultS = dao.insert("tableInsert.supplyInsert", svo);
		// 1 건 ===================================================
		
		
		// 발주 리스트
//		
//		SupplyListVo slvo = null ;
//		
//		for ( int i = 0 ; i<prod_id.length; i++) {
//			String sup = auto.autoCode("SUP12","3090000-104-2016-00061");
//			slvo = new SupplyListVo();
//			slvo.setSplylist_id(sup);
//			slvo.setSplylist_info(null);
//			slvo.setSplylist_exdate("2018-10-04");
//			slvo.setSplylist_sum(1);
//			slvo.setSupply_bcd("SUPPLY-6bacf784-0725-4055-91bd-708388e42c3d");
//			slvo.setProd_id(prod_id[i]);
//			resultSL += dao.insert("tableInsert.supply_listInsert",slvo);
//		}
//		
//		logger.debug("resultB = > {}", resultB);
//		logger.debug("resultS = > {}", resultS);
//		logger.debug("resultSL = > {}", resultSL);
//		
//	}
	

//	<insert id="supplyInsert" parameterType="supplyVo">
//	INSERT INTO SUPPLY( SUPPLY_BCD, SUPPLY_DATE, SUPPLY_STATE, SUPPLY_INFO, PLACE_ID ) 
//		   VALUES(
//			   		 #{supply_bcd  }
//					,#{supply_date }
//					,#{supply_state}
//					,#{supply_info }
//					,#{place_id    }    
//		   		 )
//	</insert>
//
//	<insert id="supply_listInsert" parameterType="supplyListVo">
//		INSERT INTO SUPPLY_LIST( SPLYLIST_ID, SPLYLIST_INFO, SPLYLIST_EXDATE, SPLYLIST_SUM, SUPPLY_BCD, PROD_ID ) 
//	       VALUES(
//			       	 #{splylist_id    } 
//					,#{splylist_info  } 
//					,#{splylist_exdate} 
//					,#{splylist_sum   } 
//					,#{supply_bcd     } 
//					,#{prod_id        }         
//	       )
//	</insert>
	
	
	@Test
	public void stocklistInsert(){
		String[] prod_id = {"biscuit-00443","biscuit-00123","biscuit-00884","biscuit-00665","biscuit-00929","biscuit-00659","biscuit-00864"
				,"necessities-00001"
				,"necessities-00002"
				,"necessities-00003"
				,"necessities-00004"
				,"necessities-00005"
				,"necessities-00006"
				,"necessities-00007"
				,"necessities-00008"
				,"necessities-00009"
				,"necessities-00010"
				,"necessities-00011"
				,"necessities-00012"
				,"necessities-00013"
				,"necessities-00014"
				,"necessities-00015"
				,"necessities-00016"
				,"necessities-00017"
				,"necessities-00018"
				,"necessities-00019"
				,"necessities-00020"
				,"necessities-00021"
				,"necessities-00022"
				,"necessities-00023"
				,"necessities-00024"
				,"necessities-00025"
				,"necessities-00026"
				,"necessities-00027"
				,"necessities-00028"
				,"necessities-00029"
				,"necessities-00030"
				,"necessities-00031"
				,"necessities-00032"
				,"necessities-00033"
				,"necessities-00034"
				,"necessities-00035"
				,"necessities-00036"
				,"necessities-00037"
				,"necessities-00038"
				,"necessities-00039"
				,"necessities-00040"
				,"necessities-00041"
				,"necessities-00042"
				,"necessities-00043"
				,"necessities-00044"
				,"necessities-00045"
				,"necessities-00046"
				,"necessities-00047"
				,"necessities-00048"
				,"necessities-00049"
				,"necessities-00050"
				,"necessities-00051"
				,"necessities-00052"
				,"necessities-00053"
				,"necessities-00054"
				,"necessities-00055"
				,"necessities-00056"
				,"necessities-00057"
				,"necessities-00058"
				,"necessities-00059"
				,"necessities-00060"
				,"necessities-00061"
				,"necessities-00062"
				,"necessities-00063"
				,"necessities-00064"
				,"necessities-00065"
				,"necessities-00066"
				,"necessities-00067"
				,"necessities-00068"
				,"necessities-00069"
				,"necessities-00070"
				,"necessities-00071"
				,"necessities-00072"
				,"necessities-00073"
				,"necessities-00074"
				,"necessities-00075"
				,"necessities-00076"
				,"necessities-00077"
				,"necessities-00078"
				,"necessities-00079"
				,"necessities-00080"
				,"necessities-00081"
				,"necessities-00082"
				,"necessities-00083"
				,"necessities-00084"
				,"necessities-00085"
				,"necessities-00086"
				,"necessities-00087"
				,"necessities-00088"
				,"necessities-00089"
				,"necessities-00090"
				,"necessities-00091"
				,"necessities-00092"
				,"necessities-00093"
				,"necessities-00094"
				,"necessities-00095"
				,"necessities-00096"
				,"necessities-00097"
				,"necessities-00098"
				,"necessities-00099"
				,"necessities-00100"
				,"necessities-00101"
				,"necessities-00102"
				,"necessities-00103"
				,"necessities-00104"
				,"necessities-00105"
				,"necessities-00106"
				,"necessities-00107"
				,"necessities-00108"
				,"necessities-00109"
				,"necessities-00110"
				,"necessities-00111"
				,"necessities-00112"
				,"necessities-00113"
				,"necessities-00114"
				,"necessities-00115"
				,"necessities-00116"
				,"necessities-00117"
				,"necessities-00118"
				,"necessities-00119"
				,"necessities-00120"
				,"necessities-00121"
				,"necessities-00122"
				,"necessities-00123"
				,"necessities-00124"
				,"necessities-00125"
				,"necessities-00126"
				,"necessities-00127"
				,"necessities-00128"
				,"necessities-00129"
				,"necessities-00130"
				,"necessities-00131"
				,"necessities-00132"
				,"necessities-00133"
				,"necessities-00134"
				,"necessities-00135"
				,"necessities-00136"
				,"necessities-00137"
				,"necessities-00138"
				,"necessities-00139"
				,"necessities-00140"
				,"necessities-00141"
				,"necessities-00142"
				,"necessities-00143"
				,"necessities-00144"
				,"necessities-00145"
				,"necessities-00146"
				,"necessities-00147"
				,"necessities-00148"
				,"food-00001"
				,"food-00002"
				,"food-00003"
				,"food-00004"
				,"food-00005"
				,"food-00006"
				,"food-00007"
				,"food-00008"
				,"food-00009"
				,"food-00010"
				,"food-00011"
				,"food-00012"
				,"food-00013"
				,"food-00014"
				,"food-00015"
				,"food-00016"
				,"food-00017"
				,"food-00018"
				,"food-00019"
				,"food-00020"
				,"food-00021"
				,"food-00022"
				,"food-00023"
				,"food-00024"
				,"food-00025"
				,"food-00026"
				,"food-00027"
				,"food-00028"
				,"food-00029"
				,"food-00030"
				,"food-00031"
				,"food-00032"
				,"food-00033"
				,"food-00034"
				,"food-00035"
				,"food-00036"
				,"food-00037"
				,"food-00038"
				,"food-00039"
				,"food-00040"
				,"food-00041"
				,"food-00042"
				,"food-00043"
				,"food-00044"
				,"food-00045"
				,"food-00046"
				,"food-00047"
				,"food-00048"
				,"food-00049"
				,"food-00050"
				,"food-00051"
				,"food-00052"
				,"food-00053"
				,"food-00054"
				,"food-00055"
				,"food-00056"
				,"food-00057"
				,"food-00058"
				,"food-00059"
				,"food-00060"
				,"food-00061"
				,"food-00062"
				,"food-00063"
				,"food-00064"
				,"food-00065"
				,"food-00066"
				,"food-00067"
				,"food-00068"
				,"food-00069"
				,"food-00070"
				,"food-00071"
				,"food-00072"
				,"food-00073"
				,"food-00074"
				,"food-00075"
				,"food-00076"
				,"food-00077"
				,"food-00078"
				,"food-00079"
				,"food-00080"
				,"food-00081"
				,"food-00082"
				,"food-00083"
				,"food-00084"
				,"food-00085"
				,"food-00086"
				,"food-00087"
				,"food-00088"
				,"food-00089"
				,"food-00090"
				,"food-00091"
				,"food-00092"
				,"food-00093"
				,"food-00094"
				,"food-00095"
				,"food-00096"
				,"food-00097"
				,"food-00098"
				,"food-00099"
				,"food-00100"
				,"food-00101"
				,"food-00102"
				,"food-00103"
				,"food-00104"
				,"food-00105"
				,"food-00106"
				,"food-00107"
				,"food-00108"
				,"food-00109"
				,"food-00110"
				,"food-00111"
				,"food-00112"
				,"food-00113"
				,"food-00114"
				,"food-00115"
				,"food-00116"
				,"food-00117"
				,"food-00118"
				,"food-00119"
				,"food-00120"
				,"food-00121"
				,"food-00122"
				,"food-00123"
				,"food-00124"
				,"food-00125"
				,"food-00126"
				,"food-00127"
				,"food-00128"
				,"food-00129"
				,"food-00130"
				,"food-00131"
				,"food-00132"
				,"food-00133"
				,"food-00134"
				,"food-00135"
				,"food-00136"
				,"food-00137"
				,"food-00138"
				,"food-00139"
				,"food-00140"
				,"food-00141"
				,"food-00142"
				,"food-00143"
				,"food-00144"
				,"food-00145"
				,"food-00146"
				,"food-00147"
				,"food-00148"
				,"food-00149"
				,"food-00150"
				,"food-00151"
				,"food-00152"
				,"food-00153"
				,"food-00154"
				,"food-00155"
				,"food-00156"
				,"food-00157"
				,"food-00158"
				,"food-00159"
				,"food-00160"
				,"food-00161"
				,"food-00162"
				,"food-00163"
				,"food-00164"
				,"food-00165"
				,"food-00166"
				,"food-00167"
				,"food-00168"
				,"food-00169"
				,"food-00170"
				,"food-00171"
				,"food-00172"
				,"food-00173"
				,"food-00174"
				,"food-00175"
				,"food-00176"
				,"food-00177"
				,"food-00178"
				,"food-00179"
				,"food-00180"
				,"food-00181"
				,"food-00182"
				,"food-00183"
				,"food-00184"
				,"food-00185"
				,"food-00186"
				,"food-00187"
				,"food-00188"
				,"food-00189"
				,"drink-00540"
				,"drink-00541"
				,"drink-00542"
				,"drink-00543"
				,"drink-00544"
				,"drink-00545"
				,"drink-00546"
				,"drink-00547"
				,"drink-00548"
				,"drink-00549"
				,"drink-00550"
				,"drink-00551"
				,"drink-00552"
				,"drink-00553"
				,"drink-00554"
				,"drink-00555"
				,"drink-00556"
				,"drink-00557"
				,"drink-00558"
				,"drink-00559"
				,"drink-00560"
				,"drink-00561"
				,"drink-00562"
				,"drink-00563"
				,"drink-00564"
				,"drink-00565"
				,"drink-00566"
				,"drink-00567"
				,"drink-00568"
				,"drink-00569"
				,"drink-00570"
				,"drink-00571"
				,"drink-00572"
				,"drink-00573"
				,"drink-00574"
				,"drink-00575"
				,"drink-00576"
				,"drink-00577"
				,"drink-00578"
				,"drink-00579"
				,"drink-00580"
				,"drink-00581"
				,"drink-00582"
				,"drink-00583"
				,"drink-00584"
				,"drink-00585"
				,"drink-00586"
				,"drink-00587"
				,"drink-00588"
				,"drink-00589"
				,"drink-00590"
				,"drink-00591"
				,"drink-00592"
				,"drink-00593"
				,"drink-00594"
				,"drink-00595"
				,"drink-00596"
				,"drink-00597"
				,"drink-00598"
				,"drink-00599"
				,"drink-00600"
				,"drink-00601"
				,"drink-00602"
				,"drink-00603"
				,"drink-00604"
				,"drink-00605"
				,"drink-00606"
				,"drink-00607"
				,"drink-00608"
				,"drink-00609"
				,"drink-00610"
				,"drink-00611"
				,"drink-00612"
				,"drink-00613"
				,"drink-00614"
				,"drink-00615"
				,"drink-00616"
				,"drink-00617"
				,"drink-00618"
				,"drink-00619"
				,"drink-00620"
				,"drink-00621"
				,"drink-00622"
				,"drink-00623"
				,"drink-00624"
				,"drink-00625"
				,"drink-00626"
				,"drink-00627"
				,"drink-00628"
				,"drink-00629"
				,"drink-00630"
				,"drink-00631"
				,"drink-00632"
				,"drink-00633"
				,"drink-00634"
				,"drink-00635"
				,"drink-00636"
				,"drink-00637"
				,"drink-00638"
				,"drink-00639"
				,"drink-00640"
				,"drink-00641"
				,"drink-00642"
				,"drink-00643"
				,"drink-00644"
				,"drink-00645"
				,"drink-00646"
				,"drink-00647"
				,"drink-00648"
				,"drink-00649"
				,"drink-00650"
				,"drink-00651"
				,"drink-00652"
				,"drink-00653"
				,"drink-00654"
				,"drink-00655"
				,"drink-00656"
				,"drink-00657"
				,"drink-00658"
				,"drink-00659"
				,"drink-00660"
				,"drink-00661"
				,"drink-00662"
				,"drink-00663"
				,"drink-00664"
				,"drink-00665"
				,"drink-00666"
				,"drink-00667"
				,"drink-00668"
				,"drink-00669"
				,"drink-00670"
				,"drink-00671"
				,"drink-00672"
				,"drink-00673"
				,"drink-00674"
				,"drink-00675"
				,"drink-00676"
				,"drink-00677"
				,"drink-00678"
				,"drink-00679"
				,"drink-00680"
				,"drink-00681"
				,"drink-00682"
				,"drink-00683"
				,"drink-00684"
				,"drink-00685"
				,"drink-00686"
				,"drink-00687"
				,"drink-00688"
				,"drink-00689"
				,"drink-00690"
				,"drink-00691"
				,"drink-00692"
				,"drink-00693"
				,"drink-00694"
				,"drink-00695"
				,"drink-00696"
				,"drink-00697"
				,"drink-00698"
				,"drink-00699"
				,"drink-00700"
				,"drink-00701"
				,"drink-00702"
				,"drink-00703"
				,"drink-00704"
				,"drink-00705"
				,"drink-00706"
				,"drink-00707"
				,"drink-00708"
				,"drink-00709"
				,"drink-00710"
				,"drink-00711"
				,"drink-00712"
				,"drink-00713"
				,"drink-00714"
				,"drink-00715"
				,"drink-00716"
				,"drink-00717"
				,"drink-00718"
				,"drink-00719"
				,"food-00380"
				,"food-00381"
				,"food-00382"
				,"food-00383"
				,"food-00384"
				,"food-00385"
				,"food-00386"
				,"food-00387"
				,"food-00388"
				,"food-00389"
				,"food-00390"
				,"food-00391"
				,"food-00392"
				,"food-00393"
				,"food-00394"
				,"food-00395"
				,"food-00396"
				,"food-00397"
				,"food-00398"
				,"food-00399"
				,"food-00400"
				,"food-00401"
				,"food-00402"
				,"food-00403"
				,"food-00404"
				,"food-00405"
				,"food-00406"
				,"food-00407"
				,"food-00408"
				,"food-00409"
				,"food-00410"
				,"food-00411"
				,"food-00412"
				,"food-00413"
				,"food-00414"
				,"food-00415"
				,"food-00416"
				,"food-00417"
				,"food-00418"
				,"food-00419"
				,"food-00420"
				,"food-00421"
				,"food-00422"
				,"food-00423"
				,"food-00424"
				,"food-00425"
				,"food-00426"
				,"food-00427"
				,"food-00428"
				,"food-00429"
				,"food-00430"
				,"food-00431"
				,"food-00432"
				,"food-00433"
				,"food-00434"
				,"food-00435"
				,"food-00436"
				,"food-00437"
				,"food-00438"
				,"food-00439"
				,"food-00440"
				,"food-00441"
				,"food-00442"
				,"food-00443"
				,"food-00444"
				,"food-00445"
				,"food-00446"
				,"food-00447"
				,"food-00448"
				,"food-00449"
				,"food-00450"
				,"food-00451"		
		};
		
//		String barCode = bar("BCD");
		Date date = new Date();
		
//		BarcodeVo bvo = new BarcodeVo();
//		bvo.setBcd_id(barCode);
//		bvo.setBcd_content("재고test");
//		bvo.setBcd_kind("100");
//		bvo.setBcd_path("test중");
//		int resultB = dao.insert("tableInsert.barcodeInsert", bvo);
		
//		String stock_id = bar("ST", "3090000-104-2016-00061");
//		StockVo stockVo = new StockVo();
//		stockVo.setStock_id(stock_id);
//		stockVo.setMem_id("3090000-104-2016-00061");
//		stockVo.setStock_info("재고test");
//		stockVo.setStock_date(date);
		
		List<SupplyListVo> supList = dao.selectList("supply.supplyDetail", "SUPPLY-6bacf784-0725-4055-91bd-708388e42c3d");
//		assertEquals(supList.size(), prod_id.length);
		
		for(int i = 0; i < supList.size(); i++){
			BarcodeVo bvo = new BarcodeVo();
			String barCode = bar("BCD");
			bvo.setBcd_id(barCode);
			bvo.setBcd_content("재고test");
			bvo.setBcd_kind("100");
			bvo.setBcd_path("test중");
			int resultB = dao.insert("tableInsert.barcodeInsert", bvo);
			
			StockListVo stlVo = new StockListVo();
			stlVo.setBcd_id(barCode);
			stlVo.setStcklist_amount(2);
			stlVo.setStcklist_exdate("2018-10-18");
			stlVo.setStck_date("2018-09-17");
			stlVo.setStcklist_info("재고test");
			stlVo.setStcklist_kind("888");
			stlVo.setProd_id(supList.get(i).getProd_id());
			stlVo.setStock_id("ST3090000-104-2016-000617466600004");
			stlVo.setSplylist_id(supList.get(i).getSplylist_id());
			dao.insert("stock.insertStockList", stlVo);
			
		}
		
	}
	
	@Test
	public void cvsServiceinsert(){
		List<CategoryVo> cvsCtgy = dao.selectList("category.getCvsServiceCtgy");
		String[] member ={"5690000-104-2017-00140",
							"5560000-104-2016-00010",
							"3220000-104-2015-00421",
						"3240000-104-2015-00075",
						"6510000-104-2015-00153",
						"3820000-104-2015-00044",
						"3270000-104-2003-00020",
						"3270000-104-2003-00001",
						"3270000-104-1994-00483",
						"3270000-104-2012-00010",
						"3270000-104-2014-00020",
						"3270000-104-2013-00005",
						"3270000-104-2013-00012",
						"3270000-104-2013-00013",
						"3270000-104-2012-00004",
						"3180000-104-2017-00231",
						"3030000-104-1993-00275",
						"3030000-104-2003-00010",
						"3030000-104-2003-00011",
						"3030000-104-2003-00001",
						"3030000-104-2003-00004",
						"3030000-104-2010-00052",
						"3030000-104-2013-00132",
						"3030000-104-2014-00073",
						"3030000-104-2014-00078",
						"3030000-104-2014-00038",
						"3030000-104-2008-00060",
						"3030000-104-2014-00052",
						"3030000-104-2005-00023",
						"4670000-104-2015-00051",
						"3330000-104-2006-00019",
						"3330000-104-1993-04230",
						"3330000-104-2008-00061",
						"3330000-104-2008-00038",
						"3330000-104-2008-00040",
						"3330000-104-2011-00017",
						"3330000-104-2011-00101",
						"3330000-104-2011-00055",
						"3330000-104-2011-00061",
						"3330000-104-2011-00070",
						"3330000-104-2010-00047",
						"3330000-104-2009-00145",
						"3330000-104-2012-00103",
						"4200000-104-2016-00073",
						"4200000-104-2016-00074",
						"3040000-104-2016-00199",
						"5380000-104-2016-00096",
						"4680000-104-2016-00069",
						"4390000-104-2016-00060",
						"3910029-104-2016-00055",
						"3380000-104-2016-00047",
						"3130000-104-2016-00316",
						"3340000-104-2016-00059",
						"4520000-104-2016-00110",
						"4100100-104-2016-00235",
						"5370000-104-2016-00117",
						"5610000-104-2016-00135",
						"3100000-104-2016-00171",
						"3080000-104-2016-00099",
						"4160000-104-2016-00026",
						"3160000-104-2016-00158",
						"3130000-104-2016-00307",
						"3060000-104-2016-00124",
						"5650000-104-2016-00095",
						"5370000-104-2016-00139",
						"5350000-104-2016-00201",
						"4690000-104-2016-00043",
						"3910000-104-2016-00008",
						"3170000-104-2016-00075",
						"3820000-104-2016-00103",
						"3820000-104-2016-00104",
						"3010000-104-2016-00164",
						"5080000-104-2016-00086",
						"5080000-104-2016-00087",
						"4520000-104-2016-00081",
						"3100000-104-2016-00098",
						"4180000-104-2016-00086",
						"3220000-104-2016-00328",
						"3680000-104-2016-00028",
						"5050000-104-2016-00115",
						"3220000-104-2016-00289",
						"4470000-104-2016-00036",
						"3790000-104-2016-00049",
						"5590000-104-2016-00037",
						"3020000-104-2016-00058",
						"4190000-104-2016-00097",
						"5630000-104-2016-00080",
						"5630000-104-2016-00083",
						"3200000-104-2016-00091",
						"4210000-104-2016-00016",
						"3820000-104-2016-00113",
						"3090000-104-2016-00051",
						"3560000-104-2016-00078",
						"3200000-104-2016-00106"};
		
		int cntRd =(int) ((Math.random()*5)+1);
		for(int k = 1; k <= cntRd; k++){
			for(int i = 0 ;  i < member.length; i++){
				
				int serviceRd = (int) ((Math.random()*8)+1);
				String service_id = bar("PLACE", member[i]);
				CvsServiceVo csVo = new CvsServiceVo();
				csVo.setCtgy_id(cvsCtgy.get(i).getCtgy_id());
				csVo.setPlace_id(member[i]);
				csVo.setService_id(service_id);
				
			}
		}
	}

}
