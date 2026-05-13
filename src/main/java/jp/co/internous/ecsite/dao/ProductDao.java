package jp.co.internous.ecsite.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.ecsite.dto.ProductDto;

/*
 * 商品情報にアクセスするためのDAO
 */
@Mapper
public interface ProductDao {

// 商品情報の全件検索
    @Select("""
    SELECT
    p.product_id,
    p.product_name,
    p.product_price,
    p.product_image_path,
    c.category_name
    FROM
    product AS p
    INNER JOIN
    category AS c
    ON
    p.category_id = c.category_id
    ORDER BY
    p.product_id;

            """)
    public ArrayList<ProductDto> getAllProducts();
    
//➀商品テーブル、商品ID
//②商品テーブル、商品名
//③商品テーブル、商品価格
//④商品テーブル、商品画像パス
//⑤カテゴリテーブル、カテゴリ名
    
// 商品IDをもとにした1件の商品情報の検索
    @Select("""
    	SELECT
    	 p.product_id,
    	 p.product_name,
    	 p.product_description,
    	 p.product_price,
    	 p.product_image_path,
    	 c.category_name
    	FROM
    	 product AS p
    	INNER JOIN
    	 category AS c
    	ON
    	 p.category_id = c.category_id
    	WHERE
    	 p.product_id = #{productld};
       """)
    public ProductDto getProductByProductId(int productId);
//54行目のproductId｢引数として指定された値がSQL文に代入されて使われる。
//description 商品詳細画面での新たな表示項目として必要｢レトロな雰囲気で明るく照らしてくれるライトです
}