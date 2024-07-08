package com.simplifit.service;

import com.simplifit.model.UserInfo;
import com.simplifit.model.HealthMetrics;
import com.simplifit.model.PersonalEvaluation;
import com.simplifit.model.BodyMeasurements;
import com.simplifit.repository.UserJPARepository;
import com.simplifit.repository.HealthMetricsJPARepository;
import com.simplifit.repository.PersonalEvaluationJPARepository;
import com.simplifit.repository.BodyMeasurementsJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnifiedService {

    private final UserJPARepository userInfoRepository;
    private final HealthMetricsJPARepository healthMetricsRepository;
    private final PersonalEvaluationJPARepository personalEvaluationRepository;
    private final BodyMeasurementsJPARepository bodyMeasurementsRepository;

    @Autowired
    public UnifiedService(UserJPARepository userInfoRepository,
                          HealthMetricsJPARepository healthMetricsRepository,
                          PersonalEvaluationJPARepository personalEvaluationRepository,
                          BodyMeasurementsJPARepository bodyMeasurementsRepository) {
        this.userInfoRepository = userInfoRepository;
        this.healthMetricsRepository = healthMetricsRepository;
        this.personalEvaluationRepository = personalEvaluationRepository;
        this.bodyMeasurementsRepository = bodyMeasurementsRepository;
    }

    // Methods for UserInfo
    public List<UserInfo> getAllUsers() {
        return userInfoRepository.findAll();
    }

    public UserInfo getUserById(Integer id) {
        return userInfoRepository.findById(id).orElse(null);
    }

    public UserInfo saveUser(UserInfo user) {
        return userInfoRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userInfoRepository.deleteById(id);
    }

    // Methods for HealthMetrics
    public List<HealthMetrics> getAllHealthMetrics() {
        return healthMetricsRepository.findAll();
    }

    public HealthMetrics getHealthMetricsById(Long id) {
        return healthMetricsRepository.findById(id).orElse(null);
    }

    public HealthMetrics saveHealthMetrics(HealthMetrics healthMetrics) {
        return healthMetricsRepository.save(healthMetrics);
    }

    public void deleteHealthMetrics(Long id) {
        healthMetricsRepository.deleteById(id);
    }

    // Methods for PersonalEvaluation
    public List<PersonalEvaluation> getAllPersonalEvaluations() {
        return personalEvaluationRepository.findAll();
    }

    public PersonalEvaluation getPersonalEvaluationById(Long id) {
        return personalEvaluationRepository.findById(id).orElse(null);
    }

    public PersonalEvaluation savePersonalEvaluation(PersonalEvaluation personalEvaluation) {
        return personalEvaluationRepository.save(personalEvaluation);
    }

    public void deletePersonalEvaluation(Long id) {
        personalEvaluationRepository.deleteById(id);
    }

    // Methods for BodyMeasurements
    public List<BodyMeasurements> getAllBodyMeasurements() {
        return bodyMeasurementsRepository.findAll();
    }

    public BodyMeasurements getBodyMeasurementsById(Long id) {
        return bodyMeasurementsRepository.findById(id).orElse(null);
    }

    public BodyMeasurements saveBodyMeasurements(BodyMeasurements bodyMeasurements) {
        return bodyMeasurementsRepository.save(bodyMeasurements);
    }

    public void deleteBodyMeasurements(Long id) {
        bodyMeasurementsRepository.deleteById(id);
    }

    
}
