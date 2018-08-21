package xlong.blogs.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xlong.blogs.model.domain.Options;
import xlong.blogs.repository.OptionsRepository;
import xlong.blogs.service.OptionsService;

/**
 * <pre>
 * 系统设置业务逻辑实现类
 * </pre>
 */
@Service
public class OptionsServiceImpl implements OptionsService {

	@Autowired
	private OptionsRepository optionsRepository;

	/**
	 * 批量保存设置
	 *
	 * @param options options
	 */
	@Override
	public void saveOptions(Map<String, String> options) {
		if (null != options && !options.isEmpty()) {
			options.forEach((k, v) -> saveOption(k, v));
		}
	}

	/**
	 * 保存单个设置选项
	 *
	 * @param key   key
	 * @param value value
	 */
	@Override
	public void saveOption(String key, String value) {
		Options options = null;
		if (StringUtils.equals(value, "")) {
			options = new Options();
			options.setOptionName(key);
			this.removeOption(options);
		} else {
			if (StringUtils.isNotEmpty(key)) {
				// 如果查询到有该设置选项则做更新操作，反之保存新的设置选项
				if (null == optionsRepository.findOptionsByOptionName(key)) {
					options = new Options();
					options.setOptionName(key);
					options.setOptionValue(value);
					optionsRepository.save(options);
				} else {
					options = optionsRepository.findOptionsByOptionName(key);
					options.setOptionValue(value);
					optionsRepository.save(options);
				}
			}
		}
	}

	/**
	 * 移除设置项
	 *
	 * @param options options
	 */
	@Override
	public void removeOption(Options options) {
		optionsRepository.delete(options);
	}

	/**
	 * 获取设置选项
	 *
	 * @return Map
	 */
	@Override
	public Map<String, String> findAllOptions() {
		Map<String, String> options = new HashMap<String, String>();
		List<Options> optionsList = optionsRepository.findAll();
		if (null != optionsList) {
			optionsList.forEach(option -> options.put(option.getOptionName(), option.getOptionValue()));
		}
		return options;
	}

	/**
	 * 根据key查询单个设置选项
	 *
	 * @param key key
	 * @return String
	 */
	@Override
	public String findOneOption(String key) {
		Options options = optionsRepository.findOptionsByOptionName(key);
		if (null != options) {
			return options.getOptionValue();
		}
		return null;
	}
}
